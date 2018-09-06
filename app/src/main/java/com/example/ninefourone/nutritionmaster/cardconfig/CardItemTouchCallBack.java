package com.example.ninefourone.nutritionmaster.cardconfig;

import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import com.example.ninefourone.nutritionmaster.adapter.CardAdapter;
import com.example.ninefourone.nutritionmaster.adapter.CardHolder;

import java.util.List;

/**
 * Created by ScorpioMiku on 2018/9/2.
 */

public class CardItemTouchCallBack extends ItemTouchHelper.Callback {

    private static final String TAG = "CardItemTouchCallBack";
    private RecyclerView mRecyclerView;
    private CardAdapter mAdapter;
    private List mDatas;

    public CardItemTouchCallBack(RecyclerView recyclerView, CardAdapter adapter, List datas) {
        this.mRecyclerView = recyclerView;
        this.mAdapter = adapter;
        this.mDatas = datas;
    }

    /**
     * 是否开启长按拖拽
     * true，开启
     * false,不开启长按退拽
     *
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    /**
     * 是否开启滑动
     * true，开启
     * false,不开启长按退拽
     *
     * @return
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    /**
     * ItemTouchHelper支持设置事件方向，并且必须重写当前getMovementFlags来指定支持的方向
     * dragFlags  表示拖拽的方向，有六个类型的值：LEFT、RIGHT、START、END、UP、DOWN
     * swipeFlags 表示滑动的方向，有六个类型的值：LEFT、RIGHT、START、END、UP、DOWN
     * 最后要通过makeMovementFlags（dragFlag，swipe）创建方向的Flag
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        /**
         * 由于我们不需要长按拖拽，所以直接传入0即可，传入0代表不监听
         */
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        return makeMovementFlags(0, swipeFlags);
    }

    /**
     * 长按item就可以拖动，然后拖动到其他item的时候触发onMove
     * 这里我们不需要
     *
     * @param recyclerView
     * @param viewHolder   拖动的viewholder
     * @param target       目标位置的viewholder
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    /**
     * 把item滑走(飞出屏幕)的时候调用
     *
     * @param viewHolder 滑动的viewholder
     * @param direction  滑动的方向
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //这里来判断画出的方向,左边是4,右边是8,然后可以做一些数据操作
        Log.d(TAG, "onSwiped: " + direction);
        switch (direction) {
            case 4:
                Log.d(TAG, "onSwiped: 左边滑出");
                mAdapter.swipe2left();
                break;
            case 8:
                Log.d(TAG, "onSwiped: 右边滑出");
                mAdapter.swipe2Right();
                break;
        }
        //移除这条数据
        Object remove = mDatas.remove(viewHolder.getLayoutPosition());

        /** 这个位置可以用来加载数据,当滑到还剩4个或者多少个时可以在后面加载数据，添加到mDatas中*/
        //这里就为了方便，直接循环了，把移除的元素再添加到末尾
        mDatas.add(mDatas.size(), remove);

        //刷新
        mAdapter.notifyDataSetChanged();
        //复位
        viewHolder.itemView.setRotation(0);
        if (viewHolder instanceof CardHolder) {
            CardHolder holder = (CardHolder) viewHolder;
        }
    }

    /**
     * 只要拖动、滑动了item,就会触发这个方法，而且是动的过程中会一直触发
     * 所以动画效果就是在这个方法中来实现的
     *
     * @param c
     * @param recyclerView
     * @param viewHolder
     * @param dX
     * @param dY
     * @param actionState
     * @param isCurrentlyActive
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                            float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        double swipeValue = Math.sqrt(dX * dX + dY * dY);   //滑动离中心的距离
        double fraction = swipeValue / (mRecyclerView.getWidth() * 0.5f);
        //边界修正 最大为1
        if (fraction > 1) {
            fraction = 1;
        }

        /**
         * 调整每个子view的缩放、位移之类的
         */
        int childCount = recyclerView.getChildCount();  //拿到子view的数量
        isUpOrDown(mRecyclerView.getChildAt(childCount - 1));
        for (int i = 0; i < childCount; i++) {
            /** 拿到子view 注意这里,先绘制的i=0，所以最下面一层view的i=0,最上面的i=3*/
            View childView = recyclerView.getChildAt(i);
            int level = childCount - i - 1;  //转换一下,level代表层数,最上面是第0层
            if (level > 0) {
                //下面层,每一层的水平方向都要增大
                childView.setScaleX((float) (1 - CardConfig.SCALE_GAP * level + fraction * CardConfig.SCALE_GAP));
                if (level < CardConfig.MAX_SHOW_COUNT - 1) {
                    //1 2层
                    childView.setScaleY((float) (1 - CardConfig.SCALE_GAP * level + fraction * CardConfig.SCALE_GAP));
                    childView.setTranslationY((float) (CardConfig.TRANS_Y_GAP * level - fraction * CardConfig.TRANS_Y_GAP));
                    childView.setTranslationZ((float) (CardConfig.TRANS_Z_GAP * (CardConfig.MAX_SHOW_COUNT - 1 - level)
                            + fraction * CardConfig.TRANS_Z_GAP));
                } else {
                    //最下面一层,3层,这层不用变,所以这里不用写
                }
            } else {
                //第0层
                //拿到水平方向的偏移比率
                float xFraction = dX / (mRecyclerView.getWidth() * 0.5f);
                //边界修正,有正有负，因为旋转有两个方向
                if (xFraction > 1) {
                    xFraction = 1;
                } else if (xFraction < -1) {
                    xFraction = -1;
                }
                //第一层左右滑动的时候稍微有点旋转
                childView.setRotation(xFraction * 15);  //这里最多旋转15度

                if (viewHolder instanceof CardHolder) {
                    CardHolder holder = (CardHolder) viewHolder;
                    if (dX > 0) {
                        //右滑,显示爱心
//                        holder.iv_love.setAlpha(xFraction);
                    } else if (dX < 0) {
                        //左滑,显示叉,注意这里xFraction为负数，所以要取反
//                        holder.iv_del.setAlpha(-xFraction);
                    } else {
//                        holder.iv_love.setAlpha(0f);
//                        holder.iv_del.setAlpha(0f);
                    }
                }
            }
        }
    }

    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
//        Log.i(TAG, "getSwipeThreshold: ");
//        if (isUpOrDown(viewHolder.itemView)) { //如果是向上或者向下滑动
//            return Float.MAX_VALUE; //就返回阈值为很大
//        }
        return super.getSwipeThreshold(viewHolder);
    }

    /**
     * 获得逃脱(swipe)速度
     *
     * @param defaultValue
     * @return
     */
    @Override
    public float getSwipeEscapeVelocity(float defaultValue) {
        Log.d(TAG, "getSwipeEscapeVelocity: " + defaultValue);
        View topView = mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1);
        if (isUpOrDown(topView)) { //如果是向上或者向下滑动
            return Float.MAX_VALUE; //就返回阈值为很大
        }
        return super.getSwipeEscapeVelocity(defaultValue);
    }


    /**
     * 获得swipe的速度阈值
     *
     * @param defaultValue
     * @return
     */
    @Override
    public float getSwipeVelocityThreshold(float defaultValue) {
        Log.d(TAG, "getSwipeVelocityThreshold: " + defaultValue);
        View topView = mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1);
        if (isUpOrDown(topView)) { //如果是向上或者向下滑动
            return Float.MAX_VALUE; //就返回阈值为很大
        }
        return super.getSwipeVelocityThreshold(defaultValue);
    }

    /**
     * 判断是否是向上滑或者向下滑
     */
    private boolean isUpOrDown(View topView) {
        float x = topView.getX();
        float y = topView.getY();
        int left = topView.getLeft();
        int top = topView.getTop();
        if (Math.pow(x - left, 2) > Math.pow(y - top, 2)) {
            //水平方向大于垂直方向
//            Log.i(TAG, "isUpOrDown: 不是");
            return false;
        } else {
            return true;
//            Log.i(TAG, "isUpOrDown: 是");
        }
    }
}
