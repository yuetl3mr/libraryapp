package aaa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datlichhen")
public class datlichhen {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "userid")
	private Integer userid;
	
	
}
