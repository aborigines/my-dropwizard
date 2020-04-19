package com.dropwizard.core;

import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "people")
@NamedQueries({
  @NamedQuery(
    name = "People.findAll",
    query = "SELECT p FROM People p"
  )
})
public class People {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(name = "firstname", nullable = false)
  private String firstName;

  @NotBlank
  @Column(name = "lastname", nullable = false)
  private String lastName;

  public People() {
  }

  public People(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
    return id.equals(people.id) &&
      Objects.equal(firstName, people.firstName) &&
      Objects.equal(lastName, people.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, firstName, lastName);
  }

  @Override
  public String toString() {
    return "People{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      '}';
  }
}
