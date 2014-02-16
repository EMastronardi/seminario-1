package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Tag;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import utilidades.GlobalsVars;
public class TagDAO {
	private static Session s = GlobalsVars.HIBERATE_SESSION;
	public static Tag getTagById(int tag){
		Tag result = (Tag) s.createQuery("from Tag where idTag = :idtag").setParameter("idtag", tag).uniqueResult();
		return result;
	}
	public static List<Tag> getAllTags(){
		List<Tag> tags = (ArrayList<Tag>)s.createQuery("from Tag").list();
		return tags;
	}
	public static List<Tag> getTagsByIds(List<Integer> tagsId){
		List<Tag> tags = (ArrayList<Tag>)s.createCriteria(Tag.class).add( Restrictions.in( "idTag", tagsId)).list();
		return tags;
	}
}
