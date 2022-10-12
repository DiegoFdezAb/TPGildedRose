package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
  @DisplayName("Test that the quality decreases if sellIn is negative")
  void testQualityIfSellin() {
    Item element = new Item("foo", 0, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(8));
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
  @DisplayName("Test that the quality of Sulfuras don't decrease when sellIn is negative")
  void testQualitySulfurasSellInNegative() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(80));
  }

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

  //These three test are added for the refactoring

  @Test
  @DisplayName("Test that sellin of Aged Brie is more than 0")
  void testSellInAgedBrie() {
    Item element = new Item("Aged Brie", 1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(0));
  }

  @Test
  @DisplayName("Test that quality of Backstage is more than 50")
  void testQualityBackstagePassesMoreThan50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test the quality of Backstage increase by 2 when sellIn is less than 11")
  void testQualityBackstageincreaseWhenSellInLessThan11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(2));
  }

  //Test for Conjured items

  @Test
  @DisplayName("Test that the quality of Conjured items decreases")
  void testQualityConjured() {
    Item element = new Item("Conjured Mana Cake", 0, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(6));
  }

  @Test
  @DisplayName("Test that the quality of Conjured items is never negative")
  void testQualityConjuredNeverNegative() {
    Item element = new Item("Conjured Mana Cake", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test that the quality of Conjured is 0 if the sellIn is positive")
  void testQualityConjuredNegativeSellInPositive() {
    Item element = new Item("Conjured Mana Cake", 1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }
}

