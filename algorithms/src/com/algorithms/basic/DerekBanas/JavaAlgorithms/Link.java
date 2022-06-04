package com.algorithms.basic.DerekBanas.JavaAlgorithms;

// https://youtu.be/195KUinjBpU
public class Link {

  public String bookName;
  public int millionsSold;

  public Link next;

  public Link(String bookName, int millionsSold) {
    this.bookName = bookName;
    this.millionsSold = millionsSold;
  }

  public void display() {
    System.out.println("\n" + bookName + ": " + millionsSold + ",000,000");
  }

  public String toString() {
    return bookName;
  }

  public static void main(String[] args) {
    LinkList theLinkList = new LinkList();
    theLinkList.insertFirstLink("don quixote", 500);
    theLinkList.insertFirstLink("a tale of two cities", 200);
    theLinkList.insertFirstLink("a lord of the rings", 150);
    theLinkList.insertFirstLink("harry potter and the sorcerer's stone", 107);

    theLinkList.display();

    System.out.println("\n" + theLinkList.find("a lord of the rings").bookName + " Was found.");

    theLinkList.removeFirst();

    theLinkList.display();

    theLinkList.removeLink("don quixote");
    theLinkList.display();
  }
}

class LinkList {
  public Link firstLink;

  LinkList() {
    firstLink = null;
  }

  public boolean isEmpty() {
    return firstLink == null;
  }

  public void insertFirstLink(String bookName, int millionsSold) {
    Link newLink = new Link(bookName, millionsSold);
    newLink.next = firstLink;
    firstLink = newLink;
  }

  public Link removeFirst() {
    Link linkReference = firstLink;
    if (isEmpty()) {
      System.out.println("Empty LinkedList");
    } else {
      firstLink = firstLink.next;
    }
    return linkReference;
  }

  public Link removeLink(String bookName) {
    Link currentLink = firstLink;
    Link previousLink = firstLink;

    while (bookName != currentLink.bookName) {
      if (currentLink.next == null) return null;
      previousLink = currentLink;
      currentLink = currentLink.next;
    }

    if (currentLink == firstLink) {
      firstLink = firstLink.next;
    } else {
      previousLink.next = currentLink.next;
    }

    return currentLink;
  }

  public void display() {
    Link theLink = firstLink;

    while (theLink != null) {
      theLink.display();

      System.out.println("Next Link: " + theLink.next);

      theLink = theLink.next;
    }
  }

  public Link find(String bookName) {
    Link theLink = firstLink;

    if (!isEmpty()) {
      while (theLink.bookName != bookName) {
        if (theLink != null) {
          theLink = theLink.next;
        } else {
          return null;
        }
      }
    } else {
      System.out.println("Empty LinkedList");
    }
    return theLink;
  }
}
