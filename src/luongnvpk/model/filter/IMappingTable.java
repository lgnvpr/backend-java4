package luongnvpk.model.filter;

import luongnvpk.model.BaseModel;
import luongnvpk.repository.BaseRepository;

public class IMappingTable{
	String type;
	String column;
	BaseRepository reposiory;
	String columFill;
	
	
	public IMappingTable() {
		super();
	}
	
	public IMappingTable(String type, String column, String columFill, BaseRepository reposiory) {
		super();
		this.type = type;
		this.column = column;
		this.reposiory = reposiory;
		this.columFill = columFill;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public BaseRepository<BaseModel> getReposiory() {
		return reposiory;
	}
	public void setReposiory(BaseRepository<BaseModel> reposiory) {
		this.reposiory = reposiory;
	}

	public String getColumFill() {
		return columFill;
	}

	public void setColumFill(String columFill) {
		this.columFill = columFill;
	}
	
	
	
}
