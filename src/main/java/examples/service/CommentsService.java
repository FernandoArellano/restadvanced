package examples.service;

import examples.database.Database;
import examples.model.Comment;
import examples.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentsService {

    private Map<Long, Message> messages = Database.getMessages();

    public List<Comment> getAllComments(long messageId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long messageId,  long commentId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size()+1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if(comment.getId()<=0){
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
