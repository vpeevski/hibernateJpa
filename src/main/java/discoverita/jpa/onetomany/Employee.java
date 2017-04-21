package discoverita.jpa.onetomany;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Employee implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEEID")
    private long employeeId;
    @Column(name = "EMPLOYEENAME")
    private String employeeName;
   
    public Employee() {
        super();
    }
   
   

    public Employee(String employeeName) {
        super();
        this.employeeName = employeeName;
    }



    public Employee(String employeeName, Company company) {
        this.employeeName = employeeName;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

}
