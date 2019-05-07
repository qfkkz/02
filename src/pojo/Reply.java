package pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
	private Integer replyId;
	private String msg;// 回复内容
	private String time;// 回复时间
	private String account;// 用户账户
	private Integer titleId;// 帖子ID

	public Reply() {
		super();
	}

	public Reply(String msg, String time, String account, int titleId) {
		super();
		this.msg = msg;
		this.time = time;
		this.account = account;
		this.titleId = titleId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTime() {
		return time;
	}

	public void setTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);
		this.time = dateNowStr;
	}

	public void setTime(String time) {

		this.time = time;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

}
