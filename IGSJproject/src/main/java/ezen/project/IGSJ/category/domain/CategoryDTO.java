package ezen.project.IGSJ.category.domain;

import org.springframework.stereotype.Component;

@Component("CategoryDTO")
public class CategoryDTO {
	private int    cno;
	private String category_name;
	private int    category_level;
	private String big_ctg;

	public CategoryDTO() {}
	public CategoryDTO(int cno, String category_name, int category_level, String big_ctg) {
		this.cno            = cno;
		this.category_name  = category_name;
		this.category_level = category_level;
		this.big_ctg        = big_ctg;
	}

	public int    getCno()                               {return cno;}
	public void   setCno(int cno)                        {this.cno = cno;}
	public String getCategory_name()                     {return category_name;}
	public void   setCategory_name(String category_name) {this.category_name = category_name;}
	public int    getCategory_level()                    {return category_level;}
	public void   setCategory_level(int category_level)  {this.category_level = category_level;}
	public String getBig_ctg()                           {return big_ctg;}
	public void   setBig_ctg(String big_ctg)             {this.big_ctg = big_ctg;}

	@Override
	public String toString() {
		return "CategoryDTO [cno=" + cno + ", category_name=" + category_name + ", category_level=" + category_level
				+ ", big_ctg=" + big_ctg + "]";
	}


} // public class CategoryDTO()