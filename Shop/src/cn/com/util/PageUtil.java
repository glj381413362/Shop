package cn.com.util;


/**
 * ��ҳ������
 * 
 * @author Administrator
 * 
 */
public class PageUtil {
	private int curPage;// ��ǰҳ��
	private int rowsPrePage;// ÿҳ��¼����
	private int maxPage;// �ܹ��ж���ҳ
	private int maxRowsCount;// �ܹ��ж���������

	/**
	 * ���췽��
	 * @param rowsPrePage ÿҳ��¼����
	 * @param maxRowsCount �ܹ��ж���������
	 */
	public PageUtil(int rowsPrePage, int maxRowsCount) {

		this.rowsPrePage = rowsPrePage;
		this.maxRowsCount = maxRowsCount;
		maxPage();//
	}

	public PageUtil() {

	}

	// ������ҳ��
	public void maxPage() {

		if (maxRowsCount % rowsPrePage == 0) {

			maxPage = maxRowsCount / rowsPrePage;
		} else {
			maxPage = maxRowsCount / rowsPrePage + 1;
		}
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getRowsPrePage() {
		return rowsPrePage;
	}

	public void setRowsPrePage(int rowsPrePage) {
		this.rowsPrePage = rowsPrePage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getMaxRowsCount() {
		return maxRowsCount;
	}

	public void setMaxRowsCount(int maxRowsCount) {
		this.maxRowsCount = maxRowsCount;
	}

}
