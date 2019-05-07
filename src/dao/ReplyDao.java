package dao;

import java.util.List;

import pojo.Reply;
import pojo.Title;

public interface ReplyDao {
	// 通过帖子ID获得回复内容
	public List<Reply> getReplyListByTitleId(Title t);

	// 添加回复内容
	public int addReply(Reply reply);
}
