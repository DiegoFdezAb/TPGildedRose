package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.beans.Transient;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  @Test
  @DisplayName("Test that the sellIn is decreased")
  void testSellIn() {
    Item element = new Item("foo", 1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(0));
  }

  @Test
  @DisplayName("Test that the quality is decreased")
  void testQuality() {
    Item element = new Item("foo", 0, 1);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test that the quality is never negative")
  void testQualityNeverNegative() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test that the quality is never more than 50")
  void testQualityNeverMoreThan50() {
    Item element = new Item("Aged Brie", 0, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }  

  @Test
  @DisplayName("Test that the quality of Aged Brie increases")
  void testQualityAgedBrie() {
    Item element = new Item("Aged Brie", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(2));
  }

  @Test
  @DisplayName("Test that the quality of Sulfuras is unchanged")
  void testQualitySulfuras() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(80));
  }

  @Test
  @DisplayName("Test that the quality of Backstage passes increases")
  void testQualityBackstagePasses() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(1));
  }

  @Test
  @DisplayName("Test that the quality of Backstage passes is 0 after concert")
  void testQualityBackstagePasses0() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }
  
  @Test
  @DisplayName("Test that the quality of non-Sulfuras decreases")
  void testQualityNonSulfuras() {
    Item element = new Item("foo", 0, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(8));
  }

  @Test
  @DisplayName("Test that the quality of Sulfuras don't decrease when sellIn is negative")
  void testQualitySulfurasSellInNegative() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(80));
  }

  //These two last are not really usefull but I wanted to put them to have the jacoco full coverage

  @Test
  @DisplayName("Test that the quality of Backstage is never more than 50 when sellIn is less than 11")
  void testQualityBackstagePassesSellInLessThan11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test that the quality of Backstage is never more than 50 when sellIn is less than 6")
  void testQualityBackstagePassesSellInLessThan6() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }
}

