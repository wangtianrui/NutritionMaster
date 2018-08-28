## 营养大师

一款基于数据分析的智能饮食推荐APP

### 需求

* 针对特殊人群,提供饮食,药膳等方案
  * 查查各种病理对食物的禁忌和需求
* 秦楚吉(1667787307) 17:41:35
  1设置整体活动水平 低：大部分坐姿，中等：大部分站立，高：大部分步行，非常高：身体需要
  2为每一个推荐菜品提供菜谱
  3根据目标卡路里-食物卡路里+运动卡路里=剩余卡路里进行每日的卡路里限制
  4区分了各类食物中蛋白质糖以及脂肪
  5以日期作为日志进行记录
  6分别针对增肌、减脂、塑形进行运动训练
  7好友社区
  8商城（健身之类）
  * **写的什么jb玩意啊?**

| 详细需求分析       | 备注   | 开发进度 |
| ------------ | ---- | ---- |
|              |      |      |
| 为每一个推荐菜品提供菜谱 |      |      |
|              |      |      |
|              |      |      |



### 数据分析

* 人体健康信息
  * 体重
  * 身高
  * 年龄
* 菜品信息
  * 菜的名称
  * 卡路里
  * 蛋白质,脂肪等
  * 推荐的食用量
* 某个人群对应的改善体质(减肥,塑性,增肌等)的方案
  * 菜谱
  * 运动方式

### 数据集和api

* 图像识别食物,获取卡路里: https://cloud.baidu.com/product/imagerecognition/fine_grained
* **nutrition facts** from food : https://www.kaggle.com/openfoodfacts/world-food-facts#en.openfoodfacts.org.products.tsv
  * https://world.openfoodfacts.org/ 数据集官网
  * 456赞,目前为止发现的最高的相关数据集
* nutrition facts for **McDonald’s** : https://www.kaggle.com/mcdonalds/nutrition-facts
  * Calories, fat, and sugar for every cheeseburger, fries, and milkshake on menu
* 更牛逼的食材分析和菜谱推荐: http://pic2recipe.csail.mit.edu/    加强版百度API
* 莫须有数据集
  * 糖尿病 时间-血糖含量关系数据 : https://archive.ics.uci.edu/ml/datasets/diabetes
  * GPA和饮食习惯的关系 : https://www.kaggle.com/borapajo/food-choices

### 应用逻辑

贴流程图

### 任务分配

| 姓名   | 任务                |
| ---- | ----------------- |
| 蒋昱葳  | 1. 网络爬虫收集相关信息和数据集 |
| 王天锐  |                   |
| 秦楚霁  |                   |
| 赵励志  |                   |

0、9种体质   //暂定
1、根据用户的体质来进行推荐菜谱与制定营养计划     ----  两种模式：9体模式和普通健身模式
2、用户可以随时输入自己当前吃的食物的名字与量     ----  随时记
3、动态爬虫——http://www.boohee.com/       每种食材的卡路里等信息（优先kaggle）
4、卡路里累加器及其可视化、每天个人信息可视化
5、https://www.xinshipu.com/      菜谱信息
6、通过照片提取出食物的卡路里等信息  百度api
7、http://www.zyyssl.com/cookbook.html    //中药食材信息、药膳信息、9体、各种病针对的药膳
8、照片识菜帮
9、http://www.ttmeishi.com/CaiXi/YaoShan/  //病人对应的食谱  
10、测算http://www.chinacaipu.com/zt/sccs.html  体质算法 
11、http://www.chinacaipu.com/menu/jianya/      特殊人群（压力之类的）



* 登陆、注册
* 输入基本信息信息（身高、体重、性别、年龄）
  * 额外信息（工作、周均运动时间、睡眠段、九体、病史）
* 针对没有填写额外信息的用户：选择减肥、增肌、塑形 、保持
* 可视化（自己的信息和目标标准的比较、根据上述选择改变）每天的量（手环、手机计步器），近几天的曲线
* 推荐菜谱：两个tab，一个定制菜谱，一个是随机智能推送
  * 单一菜推荐
  * 组合推荐
  * 一周大菜谱推荐（根据每日你自己加的一些信息动态改变）
  * 如果填了额外信息的，就是药膳推荐（一周药膳、周二普通、周三药膳。。。。）（注意可能不想减肥啥的）
* 百度api->动态录入每顿饭的信息（防抖处理，这里吹牛逼算法，推测吃了多少卡路里），识别后把，动态改变一周定制计划
* 做菜环节加入识菜帮所有功能，并加入详细食材信息卡路里等
* 针对特殊人群，混到推荐里推送有利于健康的**方法**信息（敷黄瓜方法）
* 特殊病人群体每日相关东西的摄取量的一个限定区间显示



1、服务器

2、app UI

3、可视化（计步器、可视化）

4、推荐



