<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.image.Image?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.layout.BorderPane?>

<BorderPane prefHeight="560.0" prefWidth="500.0" xmlns="http://javafx.com/javafx/15.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="application.mainMenuController">
   <top>
      <AnchorPane prefHeight="559.0" prefWidth="500.0" BorderPane.alignment="CENTER">
         <children>
            <Button fx:id="coffeeButton" layoutX="184.0" layoutY="205.0" minHeight="-Infinity" minWidth="-Infinity" mnemonicParsing="false" prefHeight="150.0" prefWidth="150.0">
               <graphic>
                  <ImageView fitHeight="163.0" fitWidth="133.0" pickOnBounds="true" preserveRatio="true">
                     <image>
                        <Image url="@../../../../Hero_14_reasons_coffee_Slide_Edit.jpg" />
                     </image>
                  </ImageView>
               </graphic>
            </Button>
            <Button fx:id="donutButton" layoutX="184.0" layoutY="21.0" minHeight="-Infinity" minWidth="-Infinity" mnemonicParsing="false" onMouseClicked="#donutMouseClick" prefHeight="150.0" prefWidth="150.0">
               <graphic>
                  <ImageView fitHeight="111.0" fitWidth="108.0" pickOnBounds="true" preserveRatio="true">
                     <image>
                        <Image url="@../../../../FullSizeRender-16.jpg" />
                     </image>
                  </ImageView>
               </graphic>
            </Button>
            <Button fx:id="yourOrderButton" layoutX="22.0" layoutY="395.0" minHeight="-Infinity" minWidth="-Infinity" mnemonicParsing="false" prefHeight="140.0" prefWidth="140.0" text="Button">
               <graphic>
                  <ImageView fitHeight="110.0" fitWidth="113.0" pickOnBounds="true" preserveRatio="true">
                     <image>
                        <Image url="@../../../../yourorders.png" />
                     </image>
                  </ImageView>
               </graphic>
            </Button>
            <Button fx:id="storeOrdersButton" layoutX="334.0" layoutY="395.0" minHeight="-Infinity" minWidth="-Infinity" mnemonicParsing="false" prefHeight="140.0" prefWidth="140.0" text="Button">
               <graphic>
                  <ImageView fitHeight="147.0" fitWidth="118.0" pickOnBounds="true" preserveRatio="true">
                     <image>
                        <Image url="@../../../../storeorders.png" />
                     </image>
                  </ImageView>
               </graphic>
            </Button>
         </children>
      </AnchorPane>
   </top>
</BorderPane>