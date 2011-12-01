/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package dstutz.conntec4.model.db;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * Person entity class that represents a person table entry in the database. Note: the javax.persitence annotations are
 * used in conjunction with hibernate, they doesn't matter for a plain JDBC implementation. The person entity class is
 * just reused for both the JDBC and hibernate solution.
 * 
 * @author Daniel Nydegger
 */
@Entity
@Table(schema = "DBBASIC", uniqueConstraints = { @UniqueConstraint(columnNames = { "memberNr" }) })
public class Person
    implements Serializable {

    private static final long serialVersionUID = 355654721000474684L;

    @SequenceGenerator(allocationSize = 1, name = "generator", sequenceName = "S_PERSON")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "generator")
    @Column(name = "ID", unique = true, nullable = false, scale = 0)
    private Long id;

    /**
     * Only used for hibernate optimistic locking mechanism.
     */
    @Column
    @Version
    private Long lockVersion;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthday;

    // @Column(nullable = false)
    // private Timestamp created;

    // @Column(nullable = false)
    // private Timestamp lastModified;

    @Column(nullable = false)
    private Integer memberNr;

    @Column(nullable = false)
    private Boolean activ;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getLockVersion() {
        return lockVersion;
    }

    // public Timestamp getCreated() {
    // return created;
    // }
    //
    // public Timestamp getLastModified() {
    // return lastModified;
    // }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    public Integer getMemberNr() {
        return memberNr;
    }

    public void setMemberNr(final Integer memberNr) {
        this.memberNr = memberNr;
    }

    public Boolean getActiv() {
        return activ;
    }

    public void setActiv(final Boolean activ) {
        this.activ = activ;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", lockVersion=" + lockVersion + ", firstname=" + firstname + ", lastname="
            + lastname + ", birthday=" + birthday + ", memberNr=" + memberNr + ", activ=" + activ + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activ == null) ? 0 : activ.hashCode());
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((memberNr == null) ? 0 : memberNr.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (activ == null) {
            if (other.activ != null) {
                return false;
            }
        } else if (!activ.equals(other.activ)) {
            return false;
        }
        if (birthday == null) {
            if (other.birthday != null) {
                return false;
            }
        } else if (!birthday.equals(other.birthday)) {
            return false;
        }
        if (firstname == null) {
            if (other.firstname != null) {
                return false;
            }
        } else if (!firstname.equals(other.firstname)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (lastname == null) {
            if (other.lastname != null) {
                return false;
            }
        } else if (!lastname.equals(other.lastname)) {
            return false;
        }
        if (memberNr == null) {
            if (other.memberNr != null) {
                return false;
            }
        } else if (!memberNr.equals(other.memberNr)) {
            return false;
        }
        return true;
    }
}
