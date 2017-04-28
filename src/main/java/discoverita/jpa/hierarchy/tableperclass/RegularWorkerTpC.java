package discoverita.jpa.hierarchy.tableperclass;

import javax.persistence.*;

@Entity
@Table(name = "regularworker")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id")),
		@AttributeOverride(name = "name", column = @Column(name = "name")) })
public class RegularWorkerTpC extends WorkerTpC {

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Column(name = "salary")
	private float salary;

	@Column(name = "bonus")
	private int bonus;

}
