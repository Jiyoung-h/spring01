package com.example.spring01.service.chart;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.inject.Inject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Service;

import com.example.spring01.model.shop.dao.CartDAO;
import com.example.spring01.model.shop.dto.CartDTO;

@Service
public class JFreeChartServiceImpl implements JFreeChartService {

	@Inject
	CartDAO cartDao;
	
	@Override
	public JFreeChart createChart() {
		List<CartDTO> list = cartDao.cartMoney();
		// 파이 차트가 아닌 경우
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(CartDTO dto : list) {
			dataset.setValue(dto.getMoney(), "과일", dto.getProduct_name());
		}
		JFreeChart chart = null;
		String title = "장바구니 통계 ";
		try {
			// 막대 그래프
			chart = ChartFactory.createBarChart(
					title, 
					"상품명", 
					"금액",
					dataset,
					PlotOrientation.VERTICAL,
					true, true, false);
			chart.getTitle().setFont(new Font("돋움", Font.BOLD, 15));
			chart.getLegend().setItemFont(new Font("돋움", Font.PLAIN, 10));
			Font font = new Font("돋움", Font.PLAIN, 12);
			Color color = new Color(0, 0, 0);
			StandardChartTheme chartTheme = (StandardChartTheme) StandardChartTheme.createJFreeTheme();
			chartTheme.setExtraLargeFont(font);
			chartTheme.setLargeFont(font);
			chartTheme.setRegularFont(font);
			
			chartTheme.setAxisLabelPaint(color);
			chartTheme.setLegendItemPaint(color);
			chartTheme.setItemLabelPaint(color);
			chartTheme.apply(chart);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return chart;
	}
}
