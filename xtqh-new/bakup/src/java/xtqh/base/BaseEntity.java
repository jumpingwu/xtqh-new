package xtqh.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {

	// @Id
	// @GeneratedValue(generator = "uuid2")
	// @GenericGenerator(name = "uuid2", strategy = "uuid2")
	// @Column(name = "ID", columnDefinition = "CHAR(36)")
	// private String id = null;

	@Column(name = "LAST_MODIFICATION_DATE")
	private Date lastModificationDate;

	@Column(name = "LAST_MODIFIER")
	private String lastModifier;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "CREATOR")
	private String creator;

	// public String getId() {
	// return id;
	// }
	//
	// public void setId(String id) {
	// this.id = id;
	// }

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(String lastModifier) {
		this.lastModifier = lastModifier;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((id == null) ? 0 : id.hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// BaseEntity other = (BaseEntity) obj;
	// if (id != null && other.id != null)
	// return (id == other.id);
	// else return false;
	// }
	//
	// @Override
	// public String toString() {
	// return "[id=" + id;
	// }
}
