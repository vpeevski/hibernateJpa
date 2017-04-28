package discoverita.jpa.hierarchy.tablepersubclass;

import javax.persistence.*;

@Entity  
@Table(name="regularworkertpsc")  
@PrimaryKeyJoinColumn(name="ID")
public class RegularWorkerTpSC extends WorkerTpSC {

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
