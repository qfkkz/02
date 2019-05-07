package service;

import java.util.List;

import pojo.Reply;
import pojo.Title;

public interface ReplyService {
	public List<Reply> getReplyById(Title t);

	public int addReply(Reply reply);
}
