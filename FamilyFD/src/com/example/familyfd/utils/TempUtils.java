package com.example.familyfd.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.familyfd.R;
import com.example.familyfd.bean.AccountType;
import com.example.familyfd.bean.Bank;
import com.example.familyfd.bean.Card;
import com.example.familyfd.bean.Exam;
import com.example.familyfd.bean.FinancialPlanner;
import com.example.familyfd.bean.Fund;
import com.example.familyfd.bean.IndexNotice;
import com.example.familyfd.bean.Insurance;
import com.example.familyfd.bean.Insurer;
import com.example.familyfd.bean.Stockjobber;
import com.example.familyfd.bean.Order;
import com.example.familyfd.bean.OrderOrganization;
import com.example.familyfd.bean.StudyInformation;
import com.example.familyfd.bean.StudyVideo;

public class TempUtils {
	public static TempUtils Instance;

	public static TempUtils getInstance() {
		return Instance == null ? new TempUtils() : Instance;
	}

	// 首页竖向广告栏
	public List<IndexNotice> getIndexNotice() {
		ArrayList<IndexNotice> mlist = new ArrayList<IndexNotice>();
		IndexNotice in1 = new IndexNotice("公告", "这里显示获取到的公告");
		IndexNotice in2 = new IndexNotice("活动", "缤纷好礼活动专区等着您");
		IndexNotice in3 = new IndexNotice("通知", "十一大奖拿到手软");
		IndexNotice in4 = new IndexNotice("消息", "您有13条未读消息");
		mlist.add(in1);
		mlist.add(in2);
		mlist.add(in3);
		mlist.add(in4);
		return mlist;
	}

	// 视频页面广告栏
	public List<ImageView> getVideoBanner(Context context) {
		ArrayList<ImageView> vList = new ArrayList<ImageView>();

		ImageView iv1 = new ImageView(context);
		iv1.setImageResource(R.drawable.test_banner6);
		iv1.setScaleType(ScaleType.FIT_XY);
		vList.add(iv1);

		ImageView iv2 = new ImageView(context);
		iv2.setImageResource(R.drawable.test_banner7);
		iv2.setScaleType(ScaleType.FIT_XY);
		vList.add(iv2);

		ImageView iv3 = new ImageView(context);
		iv3.setImageResource(R.drawable.test_banner8);
		iv3.setScaleType(ScaleType.FIT_XY);
		vList.add(iv3);

		return vList;
	}

	// 资讯页面广告栏
	public List<ImageView> getInformationBanner(Context context) {
		ArrayList<ImageView> vList = new ArrayList<ImageView>();

		ImageView iv4 = new ImageView(context);
		iv4.setImageResource(R.drawable.test_banner2);
		iv4.setScaleType(ScaleType.FIT_XY);
		vList.add(iv4);

		ImageView iv5 = new ImageView(context);
		iv5.setImageResource(R.drawable.test_banner3);
		iv5.setScaleType(ScaleType.FIT_XY);
		vList.add(iv5);

		ImageView iv6 = new ImageView(context);
		iv6.setImageResource(R.drawable.test_banner1);
		iv6.setScaleType(ScaleType.FIT_XY);
		vList.add(iv6);

		return vList;
	}

	// 课堂页面广告栏
	public List<ImageView> getClassBanner(Context context) {
		ArrayList<ImageView> vList = new ArrayList<ImageView>();

		ImageView iv1 = new ImageView(context);
		iv1.setImageResource(R.drawable.test_banner1);
		iv1.setScaleType(ScaleType.FIT_XY);
		vList.add(iv1);

		ImageView iv2 = new ImageView(context);
		iv2.setImageResource(R.drawable.test_banner2);
		iv2.setScaleType(ScaleType.FIT_XY);
		vList.add(iv2);

		ImageView iv3 = new ImageView(context);
		iv3.setImageResource(R.drawable.test_banner3);
		iv3.setScaleType(ScaleType.FIT_XY);
		vList.add(iv3);

		return vList;
	}

	// 知识页面广告栏
	public List<ImageView> getKnowledgeBanner(Context context) {
		ArrayList<ImageView> vList = new ArrayList<ImageView>();

		ImageView iv1 = new ImageView(context);
		iv1.setImageResource(R.drawable.test_banner1);
		iv1.setScaleType(ScaleType.FIT_XY);
		vList.add(iv1);

		ImageView iv2 = new ImageView(context);
		iv2.setImageResource(R.drawable.test_banner2);
		iv2.setScaleType(ScaleType.FIT_XY);
		vList.add(iv2);

		ImageView iv3 = new ImageView(context);
		iv3.setImageResource(R.drawable.test_banner3);
		iv3.setScaleType(ScaleType.FIT_XY);
		vList.add(iv3);

		ImageView iv4 = new ImageView(context);
		iv4.setImageResource(R.drawable.test_banner4);
		iv4.setScaleType(ScaleType.FIT_XY);
		vList.add(iv4);

		return vList;
	}

	// 返回风险偏好测试题
	public List<Exam> getExamList() {
		List<Exam> mList = new ArrayList<Exam>();

		Exam ex1 = new Exam();
		ex1.setId(1);
		ex1.setTitle("1、请问您的年龄处于：");
		List<String> list1 = new ArrayList<String>();
		list1.add("30岁以下");
		list1.add("31~40岁");
		list1.add("41~50岁");
		list1.add("51~60岁");
		list1.add("60岁以上");
		ex1.setOptions(list1);
		mList.add(ex1);

		Exam ex2 = new Exam();
		ex2.setId(2);
		ex2.setTitle("2、您的家庭预计进行证券投资的资金占家庭现有总资产（不含自住，自用房产及汽车等固定资产）的比例为:");
		List<String> list2 = new ArrayList<String>();
		list2.add("70%以上");
		list2.add("50~70%");
		list2.add("30~50%");
		list2.add("10~30%");
		list2.add("10%以下");
		ex2.setOptions(list2);
		mList.add(ex2);

		Exam ex3 = new Exam();
		ex3.setId(3);
		ex3.setTitle("3、进行一项重大投资后，您通常会觉得：");
		List<String> list3 = new ArrayList<String>();
		list3.add("很高兴对自己的决定很有信心");
		list3.add("轻松，基本持乐观态度");
		list3.add("基本没什么影响");
		list3.add("比较担心投资结果");
		list3.add("非常担心投资结果");
		ex3.setOptions(list3);
		mList.add(ex3);

		Exam ex4 = new Exam();
		ex4.setId(4);
		ex4.setTitle("4、如果您需要把大量的现金整体携带在身上的话，您是否会感到：");
		List<String> list4 = new ArrayList<String>();
		list4.add("非常焦虑");
		list4.add("有点焦虑");
		list4.add("完全不会焦虑");
		ex4.setOptions(list4);
		mList.add(ex4);

		Exam ex5 = new Exam();
		ex5.setId(5);
		ex5.setTitle("5、当您独自到外地游玩，遇到三叉路口，您会选择：");
		List<String> list5 = new ArrayList<String>();
		list5.add("仔细研究地图和路标");
		list5.add("找别人问路");
		list5.add("大致判断一下方向");
		list5.add("也许用掷骰子方式来做决定");
		ex5.setOptions(list5);
		mList.add(ex5);

		Exam ex6 = new Exam();
		ex6.setId(6);
		ex6.setTitle("6、假设有两种不同的投资：投资A预期获得5%的收益，有可能承担非常小的损失；投资B预期有20%的收益，但有可能面临25%甚至更高的损失。您将您的资产分配为：");
		List<String> list6 = new ArrayList<String>();
		list6.add("全部投资于A");
		list6.add("大部分投资于A");
		list6.add("两种投资各占一半");
		list6.add("大部分投资于B");
		list6.add("全部投资于B");
		ex6.setOptions(list6);
		mList.add(ex6);

		Exam ex7 = new Exam();
		ex7.setId(7);
		ex7.setTitle("7、假如您前期用25元购入一只股票，该股票现在升到30元，根据预测，该股票近期有一半机会升到35，另一半机会会跌倒25，您现在会：");
		List<String> list7 = new ArrayList<String>();
		list7.add("立刻卖出");
		list7.add("部分卖出");
		list7.add("继续持有");
		list7.add("继续买入");
		ex7.setOptions(list7);
		mList.add(ex7);

		Exam ex8 = new Exam();
		ex8.setId(8);
		ex8.setTitle("8、同上题情况，该股现在已经跌到20元。而您估计该股近期有一半机会回升到25，另一半机会跌到15，您现在会：");
		List<String> list8 = new ArrayList<String>();
		list8.add("立刻卖出");
		list8.add("部分卖出");
		list8.add("继续持有");
		list8.add("继续买入");
		ex8.setOptions(list8);
		mList.add(ex8);

		Exam ex9 = new Exam();
		ex9.setId(9);
		ex9.setTitle("9、当您进行投资时，您的首要目标是：");
		List<String> list9 = new ArrayList<String>();
		list9.add("资产保值，我不愿意承担任何投资风险");
		list9.add("尽可能保证本金的安全，不在乎收益率很低");
		list9.add("产生较多的收益，可能承担一定投资的风险");
		list9.add("实现资产大幅增长，愿意承担很大投资风险");
		ex9.setOptions(list9);
		mList.add(ex9);

		Exam ex10 = new Exam();
		ex10.setId(10);
		ex10.setTitle("10.您的投资经验可以被概况为：");
		List<String> list10 = new ArrayList<String>();
		list10.add("有限：除了银行活期账户和定期存款外，我基本上没有投资经验");
		list10.add("一般：除了银行活期账户和定期存款外，我购买过基金、保险等理财产品，但还需要进一步的指导");
		list10.add("丰富：我是一名非常有经验的投资者，参与过股票，基金等产品的交易，并倾向于自己做出的投资决策");
		list10.add("非常丰富： 我是一名非常有经验的投资者，参与过权证，期货或者创业板等高风险产品的交易");
		ex10.setOptions(list10);
		mList.add(ex10);

		Exam ex11 = new Exam();
		ex11.setId(11);
		ex11.setTitle("11、您是否了解证券市场的相关知识：");
		List<String> list11 = new ArrayList<String>();
		list11.add("从来没有过证券交易，对投资知识完全不了解");
		list11.add("学习过证券投资知识，但没有实际操作经验，不懂投资技巧");
		list11.add("了解证券市场投资知识，并且有过实际操作经验，懂得一些投资技巧");
		list11.add("参与过多年的证券交易，投资知识丰富，具有一定的专业水平");
		ex11.setOptions(list11);
		mList.add(ex11);

		Exam ex12 = new Exam();
		ex12.setId(12);
		ex12.setTitle("12、您用于证券投资的资金不会用于其他用途的时间段为：");
		List<String> list12 = new ArrayList<String>();
		list12.add("短期——1年以下");
		list12.add("中期——1到5年");
		list12.add("长期——5年以上");
		ex12.setOptions(list12);
		mList.add(ex12);

		return mList;
	}

	public List<FinancialPlanner> getIndexGoldenFinancialPlanner() {
		List<FinancialPlanner> fpList = new ArrayList<FinancialPlanner>();

		FinancialPlanner fp1 = new FinancialPlanner(R.drawable.ic_launcher,
				"张三", 10000, "金牌理财分析师", "中国平安人寿公司", "13511111111", "资深理财规划师",
				"A01235",
				"风格化复合弓风格化风格化发个 丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp1);
		FinancialPlanner fp2 = new FinancialPlanner(R.drawable.test_banner1,
				"李四", 10000, "金牌理财分析师", "中国平安人寿公司", "13600045600", "资深理财规划师",
				"A01234",
				"阿萨fghjr6thrfghbcv 克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp2);
		FinancialPlanner fp3 = new FinancialPlanner(R.drawable.test_banner11,
				"哈哈哈", 5000, "高级理财分析师", "中国平安人寿公司", "13700674000", "资深理财规划师",
				"A01233",
				"持续性查v吧v才下班查拿到了看风景克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp3);
		FinancialPlanner fp4 = new FinancialPlanner(R.drawable.account_drink,
				"张是的", 5000, "资深理财分析师", "中国平安人寿公司", "13300345600", "资深理财规划师",
				"A01232",
				"5花房姑娘没那个没那个你 看风景克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp4);
		FinancialPlanner fp5 = new FinancialPlanner(
				R.drawable.activity_visitingcard_back,
				"刘sdf公",
				5000,
				"高级理财分析师",
				"中国平安人寿公司",
				"13300326400",
				"资深理财规划师",
				"A01231",
				"中国平安人木搞就那样烦得很发的阿萨德那是你欧舒丹耐腐蚀电脑辐射拿到了看风景克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp5);
		FinancialPlanner fp6 = new FinancialPlanner(
				R.drawable.aaa,
				"刘sdf公",
				5000,
				"高级理财分析师",
				"中国平安人寿公司",
				"13300326400",
				"资深理财规划师",
				"A01231",
				"中国平安人木搞就那样烦得很发的阿萨德那是你欧舒丹耐腐蚀电脑辐射拿到了看风景克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp6);
		FinancialPlanner fp7 = new FinancialPlanner(
				R.drawable.index__study,
				"刘sdf公",
				5000,
				"高级理财分析师",
				"中国平安人寿公司",
				"13300326400",
				"资深理财规划师",
				"A01231",
				"中国平安人木搞就那样烦得很发的阿萨德那是你欧舒丹耐腐蚀电脑辐射拿到了看风景克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp7);
		FinancialPlanner fp8 = new FinancialPlanner(
				R.drawable.index_diagnose,
				"刘sdf公",
				5000,
				"高级理财分析师",
				"中国平安人寿公司",
				"13300326400",
				"资深理财规划师",
				"A01231",
				"中国平安人木搞就那样烦得很发的阿萨德那是你欧舒丹耐腐蚀电脑辐射拿到了看风景克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp8);
		FinancialPlanner fp9 = new FinancialPlanner(
				R.drawable.test_banner5,
				"刘sdf公",
				5000,
				"高级理财分析师",
				"中国平安人寿公司",
				"13300326400",
				"资深理财规划师",
				"A01231",
				"中国平安人木搞就那样烦得很发的阿萨德那是你欧舒丹耐腐蚀电脑辐射拿到了看风景克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp9);

		return fpList;
	}

	public List<FinancialPlanner> getIndexHighFinancialPlanner() {
		List<FinancialPlanner> fpList = new ArrayList<FinancialPlanner>();

		FinancialPlanner fp1 = new FinancialPlanner(R.drawable.p2_arrow_down,
				"1111张三", 10000, "金牌理财分析师", "中国平安人寿公司", "13511111111",
				"资深理财规划师", "A01235",
				"风格化复合弓风格化风格化发个 丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp1);
		FinancialPlanner fp2 = new FinancialPlanner(R.drawable.p_objects,
				"1111李四", 10000, "金牌理财分析师", "中国平安人寿公司", "13600045600",
				"资深理财规划师", "A01234",
				"阿萨fghjr6thrfghbcv 克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp2);
		FinancialPlanner fp3 = new FinancialPlanner(R.drawable.index_money,
				"1111哈哈哈", 5000, "高级理财分析师", "中国平安人寿公司", "13700674000",
				"资深理财规划师", "A01233",
				"持续性查v吧v才下班查拿到了看风景克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp3);
		FinancialPlanner fp4 = new FinancialPlanner(R.drawable.test_banner7,
				"1111张是的", 5000, "资深理财分析师", "中国平安人寿公司", "13300345600",
				"资深理财规划师", "A01232",
				"5花房姑娘没那个没那个你 看风景克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp4);
		FinancialPlanner fp5 = new FinancialPlanner(
				R.drawable.account_wages,
				"1111刘sdf公",
				5000,
				"高级理财分析师",
				"中国平安人寿公司",
				"13300326400",
				"资深理财规划师",
				"A01231",
				"中国平安人木搞就那样烦得很发的阿萨德那是你欧舒丹耐腐蚀电脑辐射拿到了看风景克里斯丁九分裤两点上课两地分居来看待发几个打卡机管理科风急浪高角度看立丰国际来看待 ");
		fpList.add(fp5);

		return fpList;
	}

	// 线下预约-全部机构

	public List<OrderOrganization> getOrganizationList() {
		List<OrderOrganization> oolist = new ArrayList<OrderOrganization>();
		OrderOrganization oo1 = new OrderOrganization("平安机构",
				"携程网旅行代金券, 现金直减, 马上出行!", "地址 : 龙华区");
		oolist.add(oo1);

		OrderOrganization oo2 = new OrderOrganization("太平洋机构",
				"拿到了看风景克里斯丁九分裤两点上课两地分居来看待!", "地址 : 罗湖区");
		oolist.add(oo2);

		OrderOrganization oo3 = new OrderOrganization("泰安机构",
				"烦得很发的阿萨德那是你欧舒丹耐腐蚀电脑辐射拿到了看风景克!", "地址 : 南山区");
		oolist.add(oo3);

		return oolist;
	}

	// 线下预约-我的预约
	public List<Order> getOrderList() {
		List<Order> olist = new ArrayList<Order>();
		Order o1 = new Order("张三", "aaaaaaaa", "资深理财规划师", "2016-06-26");
		olist.add(o1);
		Order o2 = new Order("第三方", "aaaaaaaa", "金牌理财规划师", "2016-07-09");
		olist.add(o2);
		Order o3 = new Order("不敢打", "aaaaaaaa", "高级理财规划师", "2016-09-14");
		olist.add(o3);
		Order o4 = new Order("违反", "aaaaaaaa", "金牌理财规划师", "2016-09-29");
		olist.add(o4);
		Order o5 = new Order("一体机", "aaaaaaaa", "高级理财规划师", "2016-11-07");
		olist.add(o5);

		return olist;
	}

	// 获取记一笔中的收入列表
	public List<AccountType> getIncomeType() {
		List<AccountType> incomelist = new ArrayList<AccountType>();

		AccountType ay1 = new AccountType(R.drawable.account_wages, "工资");
		incomelist.add(ay1);
		AccountType ay2 = new AccountType(R.drawable.account_extramoney, "外快兼职");
		incomelist.add(ay2);
		AccountType ay3 = new AccountType(R.drawable.account_redpacket, "红包");
		incomelist.add(ay3);
		AccountType ay4 = new AccountType(R.drawable.account_invest, "投资理财");
		incomelist.add(ay4);
		AccountType ay5 = new AccountType(R.drawable.account_prize, "奖金");
		incomelist.add(ay5);
		AccountType ay6 = new AccountType(R.drawable.account_other, "其他");
		incomelist.add(ay6);

		return incomelist;
	}

	// 获取记一笔中的支出列表
	public List<AccountType> getPayType() {
		List<AccountType> paylist = new ArrayList<AccountType>();

		AccountType ay1 = new AccountType(R.drawable.account_other, "一般");
		paylist.add(ay1);
		AccountType ay2 = new AccountType(R.drawable.account_food, "餐饮");
		paylist.add(ay2);
		AccountType ay3 = new AccountType(R.drawable.account_traffic, "交通");
		paylist.add(ay3);
		AccountType ay4 = new AccountType(R.drawable.account_drink, "酒水饮料");
		paylist.add(ay4);
		AccountType ay5 = new AccountType(R.drawable.account_supermarket,
				"超市购物");
		paylist.add(ay5);
		AccountType ay6 = new AccountType(R.drawable.account_roomcharge, "房租");
		paylist.add(ay6);
		AccountType ay7 = new AccountType(R.drawable.account_phonebill, "话费");
		paylist.add(ay7);

		return paylist;
	}

	// 获取 学习-视频 中的视频列表
	public List<Object> getStudyVideo() {

		List<Object> list = new ArrayList<Object>();

		List<String> list1 = new ArrayList<String>();
		list1.add("财商教育");
		list1.add("名师大讲堂");

		list.add(list1);

		List<Object> list2 = new ArrayList<Object>();

		List<StudyVideo> list11 = new ArrayList<StudyVideo>();

		StudyVideo sv11 = new StudyVideo();
		sv11.setImg(R.drawable.test_banner13);
		sv11.setName("马光远:民间投资");
		StudyVideo sv12 = new StudyVideo();
		sv12.setImg(R.drawable.test_banner11);
		sv12.setName("马光远:民间投资");

		list11.add(sv11);
		list11.add(sv12);

		List<StudyVideo> list21 = new ArrayList<StudyVideo>();

		StudyVideo sv21 = new StudyVideo();
		sv21.setImg(R.drawable.test_banner13);
		sv21.setName("金牌名师:控股投资");
		StudyVideo sv22 = new StudyVideo();
		sv22.setImg(R.drawable.test_banner11);
		sv22.setName("金牌名师:子女教育投资");

		list21.add(sv21);
		list21.add(sv22);

		list2.add(list11);
		list2.add(list21);

		list.add(list2);

		return list;
	}

	// 获取 学习-信息 中的视频列表
	public List<StudyInformation> getStudyInformation() {
		List<StudyInformation> list = new ArrayList<StudyInformation>();

		StudyInformation si1 = new StudyInformation();
		si1.setImg(R.drawable.test_banner7);
		si1.setName("股票基本常识");
		si1.setTip("热门");
		si1.setTime("5小时以前");

		list.add(si1);
		StudyInformation si2 = new StudyInformation();
		si2.setImg(R.drawable.test_banner9);
		si2.setName("股票基本常识2");
		si2.setTip("推荐");
		si2.setTime("7小时以前");

		list.add(si2);
		StudyInformation si3 = new StudyInformation();
		si3.setImg(R.drawable.test_banner8);
		si3.setName("债券基本常识");
		si3.setTip("推荐");
		si3.setTime("8小时以前");

		list.add(si3);
		StudyInformation si4 = new StudyInformation();
		si4.setImg(R.drawable.test_banner3);
		si4.setName("理财小技巧");
		si4.setTip("推荐");
		si4.setTime("6小时以前");

		list.add(si4);
		StudyInformation si5 = new StudyInformation();
		si5.setImg(R.drawable.test_banner5);
		si5.setName("股票基本常识");
		si5.setTip("热门");
		si5.setTime("2小时以前");

		list.add(si5);
		StudyInformation si6 = new StudyInformation();
		si6.setImg(R.drawable.test_banner4);
		si6.setName("股票基本常识");
		si6.setTip("推荐");
		si6.setTime("4小时以前");

		list.add(si6);

		return list;

	}

	public List<Card> getHotCard() {

		List<Card> mList = new ArrayList<Card>();

		Card c1 = new Card();
		c1.setId(0);
		c1.setWebaddress("http://3gqq.qq.com/");
		c1.setKind("金卡");
		c1.setPic(R.drawable.fragment_finance_bankcard_gs);
		c1.setCard_name("中国工商银行");
		List<String> list1 = new ArrayList<String>();
		list1.add("周五超市加油返8%刷卡金");
		list1.add("可asfsdf提现");
//		list1.add("水调歌头挂号费搞好规范");

		c1.setAdvantage(list1);
		c1.setApply_num(10799);

		mList.add(c1);

		Card c2 = new Card();
		c2.setId(1);
		c2.setKind("白金卡");
		c2.setPic(R.drawable.fragment_finance_bankcard_gm);
		c2.setCard_name("中国光明银行");
		c2.setWebaddress("http://www.sina.com.cn");
		List<String> list2 = new ArrayList<String>();
		list2.add("有\"芯\"更放心");
		list2.add("首刷增10万积分");
		c2.setAdvantage(list2);
		c2.setApply_num(88695);

		mList.add(c2);

		Card c3 = new Card();
		c3.setId(2);
		c3.setKind("普通卡");
		c3.setPic(R.drawable.fragment_finance_bankcard_zg);
		c3.setWebaddress("http://www.jd.com");
		c3.setCard_name("中国银行标准信用卡");
		List<String> list3 = new ArrayList<String>();
		list3.add("12元看电影");
		list3.add("可100%额度提现");
		c3.setAdvantage(list3);
		c3.setApply_num(135264);

		mList.add(c3);

		return mList;
	}

	public List<Bank> getBankList() {
		List<Bank> mList = new ArrayList<Bank>();

		Bank b1 = new Bank();
		b1.setName("中国银行");
		b1.setImg(R.drawable.fragment_finance_bank_zg);
		mList.add(b1);

		Bank b2 = new Bank();
		b2.setName("平安银行");
		b2.setImg(R.drawable.fragment_finance_bank_chinasafe);
		mList.add(b2);

		Bank b3 = new Bank();
		b3.setName("招商银行");
		b3.setImg(R.drawable.fragment_finance_bank_zs);
		mList.add(b3);

		Bank b4 = new Bank();
		b4.setName("交通银行");
		b4.setImg(R.drawable.fragment_finance_bank_jt);
		mList.add(b4);

		Bank b5 = new Bank();
		b5.setName("建设银行");
		b5.setImg(R.drawable.fragment_finance_bank_js);
		mList.add(b5);

		Bank b6 = new Bank();
		b6.setName("工商银行");
		b6.setImg(R.drawable.fragment_finance_bank_gs);
		mList.add(b6);

		return mList;
	}
	
	public List<Insurer> getInsurerList(){
		List<Insurer> list=new ArrayList<Insurer>();
		
		Insurer i1=new Insurer();
		i1.setName("太平洋保险");
		i1.setImg(R.drawable.fragment_finance_insure_pacific);
		list.add(i1);
		Insurer i2=new Insurer();
		i2.setName("中国平安");
		i2.setImg(R.drawable.fragment_finance_insure_chinasafe);
		list.add(i2);
		Insurer i3=new Insurer();
		i3.setName("人保寿险");
		i3.setImg(R.drawable.fragment_finance_insure_chinapepole);
		list.add(i3);
		Insurer i4=new Insurer();
		i4.setName("阳光人寿");
		i4.setImg(R.drawable.fragment_finance_insure_sunshine);
		list.add(i4);
		Insurer i5=new Insurer();
		i5.setName("中银保险");
		i5.setImg(R.drawable.fragment_finance_bank_zg);
		list.add(i5);
		
		return list;
	}
	
	public List<Insurance> getInsuranceList(){
		List<Insurance> list=new ArrayList<Insurance>();
		Insurance i1=new Insurance();
		i1.setName("小雨伞-成年人重疾险");
		i1.setImg(R.drawable.fragment_finance_insure_chinapepole);
		i1.setIntroduce("针对家庭的顶梁柱量身定制,保障多达50种重大疾病,每天仅需1.3元");
		i1.setAge("18-50岁");
		i1.setTerm("1年");
		i1.setDetailimg(R.drawable.test_banner9);
		i1.setPrice(90);
		list.add(i1);
		
		Insurance i2=new Insurance();
		i2.setName("小雨伞-成年人重疾险");
		i2.setImg(R.drawable.fragment_finance_insure_chinapepole);
		i2.setIntroduce("针对家庭的顶梁柱量身定制,保障多达50种重大疾病,每天仅需1.3元");
		i2.setAge("18-50岁");
		i2.setTerm("1年");
		i1.setDetailimg(R.drawable.test_banner8);
		i2.setPrice(91);
		list.add(i2);
		
		Insurance i3=new Insurance();
		i3.setName("小雨伞-成年人重疾险");
		i3.setImg(R.drawable.fragment_finance_insure_chinapepole);
		i3.setIntroduce("针对家庭的顶梁柱量身定制,保障多达50种重大疾病,每天仅需1.3元");
		i3.setAge("18-50岁");
		i3.setTerm("1年");
		i1.setDetailimg(R.drawable.test_banner5);
		i3.setPrice(92);
		list.add(i3);
		
		return list;
	}
	
	//获取热门基金列表
	public List<Fund> getHotFundList(){
		List<Fund> flist=new ArrayList<Fund>();
		Fund f1=new Fund();
		f1.setName("中油战略新欣产业混合");
		f1.setItem("仓位灵活,攻守兼备");
		f1.setFallrise("25.01%");
		f1.setId("032623");
		flist.add(f1);
		Fund f2=new Fund();
		f2.setName("华夏南方多利");
		f2.setItem("擅长波段的债券");
		f2.setFallrise("27.63%");
		f2.setId("032624");
		flist.add(f2);
		Fund f3=new Fund();
		f3.setName("新欣产业混合");
		f3.setItem("仓位灵活,攻守兼备");
		f3.setFallrise("24.94%");
		f3.setId("034223");
		flist.add(f3);
		
		return flist;
	}
	
	
	
	//获取股票类基金列表
	public List<Fund> getSharesFundList(){
		List<Fund> flist=new ArrayList<Fund>();
		Fund f1=new Fund();
		f1.setName("股票类中油战略新欣产业混合");
		f1.setItem("仓位灵活,攻守兼备");
		f1.setFallrise("15.01%");
		flist.add(f1);
		f1.setId("032623");
		Fund f2=new Fund();
		f2.setName("股票类华夏南方多利");
		f2.setItem("擅长波段的债券");
		f2.setId("000623");
		f2.setFallrise("17.63%");
		flist.add(f2);
		Fund f3=new Fund();
		f3.setName("股票类新欣产业混合");
		f3.setItem("仓位灵活,攻守兼备");
		f3.setId("000023");
		f3.setFallrise("14.94%");
		flist.add(f3);
		
		return flist;
	}
	
	//获取全部基金列表
	public List<Fund> getAllFundList(){
		List<Fund> flist=new ArrayList<Fund>();
		Fund f1=new Fund();
		f1.setName("all股票类中油战略新欣产业混合");
		f1.setItem("仓位灵活,攻守兼备");
		f1.setFallrise("15.01%");
		f1.setId("096523");
		flist.add(f1);
		Fund f2=new Fund();
		f2.setName("all股票类华夏南方多利");
		f2.setItem("擅长波段的债券");
		f2.setFallrise("17.63%");
		f2.setId("966423");
		flist.add(f2);
		Fund f3=new Fund();
		f3.setName("all股票类新欣产业混合");
		f3.setItem("仓位灵活,攻守兼备");
		f3.setFallrise("14.94%");
		f3.setId("152023");
		flist.add(f3);
		Fund f4=new Fund();
		f4.setName("all股票类中油战略新欣产业混合");
		f4.setItem("仓位灵活,攻守兼备");
		f4.setFallrise("15.01%");
		f4.setId("965023");
		flist.add(f4);
		Fund f5=new Fund();
		f5.setName("all股票类华夏南方多利");
		f5.setItem("擅长波段的债券");
		f5.setFallrise("17.63%");
		f5.setId("096523");
		flist.add(f5);
		Fund f6=new Fund();
		f6.setName("all股票类新欣产业混合");
		f6.setItem("仓位灵活,攻守兼备");
		f6.setFallrise("14.94%");
		f6.setId("096823");
		flist.add(f6);
		
		return flist;
	}

	
	//获取偏股基金列表
	public List<Fund> getPSFundList(){
		List<Fund> flist=new ArrayList<Fund>();
		Fund f1=new Fund();
		f1.setName("偏股股票类中油战略新欣产业混合");
		f1.setItem("仓位灵活,攻守兼备");
		f1.setFallrise("15.01%");
		f1.setId("965023");
		flist.add(f1);
		Fund f2=new Fund();
		f2.setName("偏股股票类华夏南方多利");
		f2.setItem("擅长波段的债券");
		f2.setFallrise("17.63%");
		f2.setId("096023");
		flist.add(f2);
		Fund f3=new Fund();
		f3.setName("偏股股票类新欣产业混合");
		f3.setItem("仓位灵活,攻守兼备");
		f3.setFallrise("14.94%");
		f3.setId("000023");
		flist.add(f3);
		Fund f4=new Fund();
		f4.setName("偏股股票类中油战略新欣产业混合");
		f4.setItem("仓位灵活,攻守兼备");f4.setId("000023");
		f4.setFallrise("15.01%");
		flist.add(f4);
		
		return flist;
	}
	
	
	
	
	//获取混合类基金列表
	public List<Fund> getMixFundList(){
		List<Fund> flist=new ArrayList<Fund>();
		Fund f1=new Fund();
		f1.setName("混合类股票类中油战略新欣产业混合");
		f1.setItem("仓位灵活,攻守兼备");
		f1.setFallrise("15.01%");
		f1.setId("000023");
		flist.add(f1);
		Fund f2=new Fund();
		f2.setName("混合类股票类华夏南方多利");
		f2.setItem("擅长波段的债券");
		f2.setId("000023");
		f2.setFallrise("17.63%");
		flist.add(f2);
		Fund f3=new Fund();
		f3.setName("混合类股票类新欣产业混合");
		f3.setItem("仓位灵活,攻守兼备");
		f3.setId("000023");
		f3.setFallrise("14.94%");
		flist.add(f3);
		Fund f4=new Fund();
		f4.setName("混合类股票类中油战略新欣产业混合");
		f4.setItem("仓位灵活,攻守兼备");
		f4.setFallrise("15.01%");
		f4.setId("000023");
		flist.add(f4);
		Fund f5=new Fund();
		f5.setName("混合类股票类华夏南方多利");
		f5.setItem("擅长波段的债券");
		f5.setId("000023");
		f5.setFallrise("17.63%");
		flist.add(f5);
		Fund f6=new Fund();
		f6.setName("混合类股票类新欣产业混合");
		f6.setId("000023");
		f6.setItem("仓位灵活,攻守兼备");
		f6.setFallrise("14.94%");
		flist.add(f6);
		
		return flist;
	}
	
	
	//获取债券类基金列表
	public List<Fund> getBondFundList(){
		List<Fund> flist=new ArrayList<Fund>();
		Fund f1=new Fund();
		f1.setName("债券类股票类中油战略新欣产业混合");
		f1.setItem("仓位灵活,攻守兼备");
		f1.setFallrise("15.01%");
		f1.setId("000023");
		flist.add(f1);
		Fund f2=new Fund();
		f2.setName("债券类股票类华夏南方多利");
		f2.setItem("擅长波段的债券");
		f2.setFallrise("17.63%");
		f2.setId("000023");
		flist.add(f2);
		Fund f3=new Fund();
		f3.setName("债券类股票类新欣产业混合");
		f3.setItem("仓位灵活,攻守兼备");
		f3.setId("000023");
		f3.setFallrise("14.94%");
		flist.add(f3);
		Fund f4=new Fund();
		f4.setName("债券类股票类中油战略新欣产业混合");
		f4.setItem("仓位灵活,攻守兼备");
		f4.setId("000023");
		f4.setFallrise("15.01%");
		flist.add(f4);
		Fund f5=new Fund();
		f5.setName("债券类股票类华夏南方多利");
		f5.setItem("擅长波段的债券");
		f5.setFallrise("17.63%");
		f5.setId("000023");
		flist.add(f5);
		Fund f6=new Fund();
		f6.setName("债券类股票类新欣产业混合");
		f6.setItem("仓位灵活,攻守兼备");
		f6.setId("000023");
		f6.setFallrise("14.94%");
		flist.add(f6);
		
		return flist;
	}
	
	
	//获取指数类基金列表
	public List<Fund> getPointFundList(){
		List<Fund> flist=new ArrayList<Fund>();
		Fund f1=new Fund();
		f1.setName("指数类股票类中油战略新欣产业混合");
		f1.setItem("仓位灵活,攻守兼备");
		f1.setFallrise("15.01%");
		flist.add(f1);
		Fund f2=new Fund();
		f2.setName("指数类股票类华夏南方多利");
		f2.setItem("擅长波段的债券");
		f2.setFallrise("17.63%");
		flist.add(f2);
		Fund f3=new Fund();
		f3.setName("指数类股票类新欣产业混合");
		f3.setItem("仓位灵活,攻守兼备");
		f3.setFallrise("14.94%");
		flist.add(f3);
		Fund f4=new Fund();
		f4.setName("指数类股票类中油战略新欣产业混合");
		f4.setItem("仓位灵活,攻守兼备");
		f4.setFallrise("15.01%");
		flist.add(f4);
		Fund f5=new Fund();
		f5.setName("指数类股票类华夏南方多利");
		f5.setItem("擅长波段的债券");
		f5.setFallrise("17.63%");
		flist.add(f5);
		Fund f6=new Fund();
		f6.setName("指数类股票类新欣产业混合");
		f6.setItem("仓位灵活,攻守兼备");
		f6.setFallrise("14.94%");
		flist.add(f6);
		
		return flist;
	}
	
	public List<Stockjobber> getUSStockList(){
		List<Stockjobber> slist=new ArrayList<Stockjobber>();
		Stockjobber s1=new Stockjobber();
		s1.setName("US招商证券");
		s1.setImg(R.drawable.test_banner3);
		s1.setIntroduce("招商战略投资");
		s1.setBenefit1("成功开户送100元红包");
		s1.setBenefit2("首次存钱送300元红包");
		slist.add(s1);
		
		Stockjobber s2=new Stockjobber();
		s2.setName("US招商证券");
		s2.setImg(R.drawable.test_banner1);
		s2.setIntroduce("招商战略投资");
		s2.setBenefit1("成功开户送100元红包");
		s2.setBenefit2("首次存钱送300元红包");
		slist.add(s2);
		
		
		return slist;
	}
	public List<Stockjobber> getAStockList(){
		List<Stockjobber> slist=new ArrayList<Stockjobber>();
		Stockjobber s1=new Stockjobber();
		s1.setName("A招商证券");
		s1.setImg(R.drawable.test_banner4);
		s1.setIntroduce("招商战略投资");
		s1.setBenefit1("成功开户送100元红包");
		s1.setBenefit2("首次存钱送300元红包");
		slist.add(s1);
		
		Stockjobber s2=new Stockjobber();
		s2.setName("A招商证券");
		s2.setImg(R.drawable.test_banner5);
		s2.setIntroduce("招商战略投资");
		s2.setBenefit1("成功开户送100元红包");
		s2.setBenefit2("首次存钱送300元红包");
		slist.add(s2);
		
		
		return slist;
	}
}
