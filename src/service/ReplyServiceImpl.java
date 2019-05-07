package service;

import java.util.List;

import dao.ReplyDao;
import dao.ReplyDaoImpl;
import pojo.Reply;
import pojo.Title;

public class ReplyServiceImpl implements ReplyService{
	ReplyDao rd=new ReplyDaoImpl();
	public List<Reply> getReplyById(Title t){
		return rd.getReplyListByTitleId(t);
		
	};

	public int addReply(Reply reply) {
		return rd.addReply(reply);
	};
}
