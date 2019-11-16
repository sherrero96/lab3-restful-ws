package rest.addressbook.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A really simple Address Book. This class is not thread safe.
 */
public class AddressBook {

  private int nextId = 1;
  private List<Person> personList = new ArrayList<>();

    public AddressBook(AddressBook ab) {
      this.nextId = ab.getNextId();
      this.personList = new ArrayList<>(personList);
    }

  public AddressBook() {

  }

  /**
   * The value of next unique identifier.
   *
   * @return the next unique identifier.
   */
  public int getNextId() {
    return nextId;
  }

  public void setNextId(int nextId) {
    this.nextId = nextId;
  }

  /**
   * The list of persons in this address book.
   *
   * @return a person list.
   */
  public List<Person> getPersonList() {
    return personList;
  }

  public void setPersonList(List<Person> persons) {
    this.personList = persons;
  }

  /**
   * Returns the old next identifier and increases the new value in one.
   *
   * @return an identifier.
   */
  public int nextId() {
    int oldValue = nextId;
    nextId++;
    return oldValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AddressBook that = (AddressBook) o;
    return nextId == that.nextId &&
            Objects.equals(personList, that.personList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextId, personList);
  }
}
