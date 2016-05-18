val weather =
  <rss>
    <channel>
      <title>Yahoo! Weather - Boulder, CO</title>
      <item>
        <title>Conditions for Boulder, CO at 2:54 pm MST</title>
        <forecast day="Thu" date="10 Nov 2011" low="37" high="58" text="Partly Cloudy"
                  code="29" />
        <forecast day="Thu" date="10 Nov 2011" low="37" high="58" text="Partly Cloudy"
                  code="29" />
      </item>
    </channel>
  </rss>

val forecast = weather \ "channel" \ "item" \ "forecast"

forecast.map(println(_))

val xml =
  <order>
    <item name="Pizza" price="12.00">
      <pizza>
        <crust type="thin" size="14" />
        <topping>cheese</topping>
        <topping>sausage</topping>
      </pizza>
    </item>
    <item name="Breadsticks" price="4.00">
      <breadsticks />
    </item>
    <tax type="federal">0.80</tax>
    <tax type="state">0.80</tax>
    <tax type="local">0.40</tax>
  </order>


val toppings = (xml \ "item" \ "pizza" \ "topping").map(_.text)










