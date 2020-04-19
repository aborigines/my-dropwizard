package com.dropwizard.core;

import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "people")
@NamedQueries({
  @NamedQuery(
    name = "com.dropwizard.core.People.findAll",
    query = "SELECT p FROM People p"
  )
})
public class People {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer Id;

  @Column(name = "firstname", nullable = false)
  private String firstName;

  @Column(name = "lastname", nullable = false)
  private String lastName;

  public People() {
  }

  public People(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    People people = (People) o;
    return Id.equals(people.Id) &&
      Objects.equal(firstName, people.firstName) &&
      Objects.equal(lastName, people.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(Id, firstName, lastName);
  }

  @Override
  public String toString() {
    return "People{" +
      "Id=" + Id +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      '}';
  }
}
