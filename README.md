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

| 详细需求分析             | 备注 | 开发进度 |
| ------------------------ | ---- | -------- |
|                          |      |          |
| 为每一个推荐菜品提供菜谱 |      |          |
|                          |      |          |
|                          |      |          |



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
* 更牛逼的食材分析和菜谱推荐: http://pic2recipe.csail.mit.edu/
* 莫须有数据集
  * 糖尿病 时间-血糖含量关系数据 : https://archive.ics.uci.edu/ml/datasets/diabetes
  * GPA和饮食习惯的关系 : https://www.kaggle.com/borapajo/food-choices

### 应用逻辑

贴流程图

### 任务分配

| 姓名   | 任务                            |
| ------ | ------------------------------- |
| 蒋昱葳 | 1. 网络爬虫收集相关信息和数据集 |
| 王天锐 |                                 |
| 秦楚霁 |                                 |
| 赵励志 |                                 |





