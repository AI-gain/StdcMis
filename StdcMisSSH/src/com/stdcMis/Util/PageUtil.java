package com.stdcMis.Util;

public class PageUtil {
	
	public static Page createPage(int everyPage,int totalCount,int currentPage)
	{
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage,totalCount);
		int beginIndex = getBeginIndex(everyPage,currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage,currentPage);
		return new Page(everyPage,currentPage,totalCount,totalPage,beginIndex,hasPrePage,hasNextPage);
	}
	
	public static Page createPage(Page page,int totalCount)
	{
		int everyPage = getEveryPage(page.getEveryPage());
		int currentPage = getCurrentPage(page.getCurrentPage());
		int totalPage = getTotalPage(page.getCurrentPage(),totalCount);
		int beginIndex = getBeginIndex(everyPage,totalPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage,currentPage);
		return new Page(everyPage,currentPage,totalCount,totalPage,beginIndex,hasPrePage,hasNextPage);
	}
	
	//设置每页记录数
	public static int getEveryPage(int everyPage)
	{
		return everyPage == 0 ? 10 : everyPage;
	}
	
	//设置当前页
	public static int getCurrentPage(int currentPage)
	{
		return currentPage == 0 ? 1 : currentPage;
	}
	
	//设置总页数，需要总记录数和每页显示的数量
	public static int getTotalPage(int everyPage,int totalCount)
	{
		int totalPage = 0;
		if(totalCount % everyPage == 0)
		{
			totalPage = totalCount/everyPage;
		}
		else
		{
			totalPage = totalCount/everyPage + 1;
		}
		return totalPage;
	}
	
	//设置起始点，需要每页显示多少和当前页
	public static int getBeginIndex(int everyPage,int currentPage)
	{
		return (currentPage - 1) * everyPage;
	}
	
	//设置是否有上一页,需要当前页
	public static boolean getHasPrePage(int currentPage)
	{
		return currentPage == 1 ? false : true;
	}
	
	//设置是否有下一页,需要当前页
	public static boolean getHasNextPage(int totalPage,int currentPage)
	{
		return currentPage == totalPage ? false : true; 
	}
}
