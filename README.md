
## 营养大师

一款基于数据分析的智能饮食推荐APP  

仓库地址: https://github.com/wangtianrui/NutritionMaster

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

**赵励志收集的资料**

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

**王天锐收集的资料**

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



### 需求分析

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
* ocr体检单信息录入

* **针对照片中菜的数量分析吃了多少菜,包含多少卡路里**

**技术难点**

1、服务器

2、app UI

3、可视化（计步器、可视化）

4、推荐



### 数据库设计

![2](http://ww1.sinaimg.cn/large/0077h8xtly1fuz0a6yb4gj30z10hl1kx.jpg)

**加下划线为主码,加粗为外码,默认not null**

* **菜谱**(<u>str菜名</u>,  **nullable str体质_名称**(对应最优菜谱的效果) ,int卡路里,int制作时间(分钟),str口味,str工艺,str做法,str图片url)
  * menu
* **食材**( <u>str名称</u>)
  * material
* **体质**(<u>str体质名称</u>,str体质特点,str运动调理方式)
  * physique
* **体质性状**(<u>str性状名称</u>)
  * Physical properties
* **菜谱功能和分类**( <u>str分类名称</u>)
  * menu classification
* **用户**( <u>str用户名</u>,str密码, **nullable str 体质-名称**,**nullable str特殊职业**)
  * User
* **特殊职业**( <u>str职业名称</u>)
  * Occupation
* 菜谱功能分类_可治愈的职业\_特殊职业( <u> **特殊职业-str职业名称**</u>, <u> **菜谱功能和分类-str分类名称**</u>)
* 菜谱\_做菜_食材 ( <u>**str菜谱-菜名**</u>,**<u>str食材-名称**</u>,int用量)
  * cook quantity
* 食材\_效果_体质(<u> **str食材-名称**</u>,<u> **nullable str体质-名称**</u>,int效果(1有利于,0不利于))
  * Material effect
* 体质\_身体状态_体质性状( <u> **str体质-名称**</u>, <u> **str体质性状-性状名称**</u>)
  * physical_state
* 菜谱\_菜谱效果_菜谱功能和分类( <u> **str菜谱-菜名**</u>, <u> **str菜谱功能和分类-分类名称**</u>)
  * menu_effect



### 服务器请求

| 说明         | 方法 | 请求示例                                            | 备注                                                    |
| ------------ | ---- | --------------------------------------------------- | ------------------------------------------------------- |
| 查询菜单信息 | GET  | http://120.77.182.38/menus/某菜名/                  | 不加菜名默认请求所有菜单(服务器可能扛不住)              |
| 查询食材信息 | GET  | http://120.77.182.38/foodmaterial/西红柿/           | 同上                                                    |
| 查询用户信息 | GET  | http://120.77.182.38/myuser/zhaolizhi/              | 同上                                                    |
| 新建用户信息 | POST | http://120.77.182.38/myuser/                        | 参数见下图                                              |
| 查询菜谱分类 | GET  | http://120.77.182.38/menuclassification/糖尿病食谱/ | 不加分类名默认请求所有分类(和对应的菜谱),响应时间较长   |
| 查询职业信息 | GET  | http://120.77.182.38/occupation/电力工程师/         | 不加职业名默认查询所有,响应较快  返回职业对应的菜单分类 |
| 查询体质信息 | GET  | http://120.77.182.38/physique/气虚质/               | 返回体质需要的食材                                      |
|              |      |                                                     |                                                         |
|              |      |                                                     |                                                         |

* POST新建用户信息`params`示例

  * 1♂   0♀
  * `occupation_name`,`physical_name`的值必须和数据库对应

  ![](http://ww1.sinaimg.cn/large/0077h8xtly1fvjbfh6vm1j30r70eh3zj.jpg)
