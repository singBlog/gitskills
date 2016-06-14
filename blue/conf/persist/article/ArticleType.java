package persist.article;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"serial"})
public class ArticleType  implements java.io.Serializable {

     private Integer id;
     private String typeName;
     private String typeDesc;
 
     //
     private int userid;
     //
     
     
	@SuppressWarnings("unchecked")
	private Set articles = new HashSet(0);

    public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Integer getId() {
        return this.id;
    }

    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	
	@SuppressWarnings("unchecked")
	public Set getArticles() {
        return this.articles;
    }

    @SuppressWarnings("unchecked")
	public void setArticles(Set articles) {
        this.articles = articles;
    }
}