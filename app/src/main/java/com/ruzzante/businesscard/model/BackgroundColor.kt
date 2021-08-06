package com.ruzzante.businesscard.model


class BackgroundColor (
    colorName:String, colorHexa:String
        ){
    val colorName:String = colorName
    val colorHexa:String = colorHexa

    companion object{
        val colorList:List<BackgroundColor> ?= getColors()

        fun getColors():List<BackgroundColor>{
            return listOf<BackgroundColor>(
                BackgroundColor(colorName="DarkGray", colorHexa="#A9A9A9"),
                BackgroundColor(colorName="Silver", colorHexa="#C0C0C0"),
                BackgroundColor(colorName="LightGrey", colorHexa="#D3D3D3"),
                BackgroundColor(colorName="SlateBlue", colorHexa="#6A5ACD"),
                BackgroundColor(colorName="SlateBlue1", colorHexa="#836FFF"),
                BackgroundColor(colorName="SlateBlue3", colorHexa="#6959CD"),
                BackgroundColor(colorName="DarkSlateBlue", colorHexa="#483D8B"),
                BackgroundColor(colorName="CornflowerBlue", colorHexa="#6495ED"),
                BackgroundColor(colorName="RoyalBlue", colorHexa="#4169E1"),
                BackgroundColor(colorName="DodgerBlue", colorHexa="#1E90FF"),
                BackgroundColor(colorName="DeepSkyBlue", colorHexa="#00BFFF"),
                BackgroundColor(colorName="LightSkyBlue", colorHexa="#87CEFA"),
                BackgroundColor(colorName="SkyBlue", colorHexa="#87CEEB"),
                BackgroundColor(colorName="DarkTurquoise", colorHexa="#00CED1"),
                BackgroundColor(colorName="Turquoise", colorHexa="#40E0D0"),
                BackgroundColor(colorName="MediumTurquoise", colorHexa="#48D1CC"),
                BackgroundColor(colorName="LightSeaGreen", colorHexa="#20B2AA"),
                BackgroundColor(colorName="DarkCyan", colorHexa="#008B8B"),
                BackgroundColor(colorName="SpringGreen", colorHexa="#00FF7F"),
                BackgroundColor(colorName="PaleGreen", colorHexa="#98FB98"),
                BackgroundColor(colorName="LightGreen", colorHexa="#90EE90"),
                BackgroundColor(colorName="DarkSeaGreen", colorHexa="#8FBC8F"),
                BackgroundColor(colorName="MediumSeaGreen", colorHexa="#3CB371"),
                BackgroundColor(colorName="MediumOrchid", colorHexa="#BA55D3"),
                BackgroundColor(colorName="Purple", colorHexa="#A020F0"),
                BackgroundColor(colorName="HotPink", colorHexa="#FF69B4"),
                BackgroundColor(colorName="PaleVioletRed", colorHexa="#DB7093"),
                BackgroundColor(colorName="FireBrick", colorHexa="#B22222"),
                BackgroundColor(colorName="Salmon", colorHexa="#FA8072"),
                BackgroundColor(colorName="Red", colorHexa="#FF0000"),
                BackgroundColor(colorName="OrangeRed", colorHexa="#FF4500"),
                BackgroundColor(colorName="DarkOrange", colorHexa="#FF8C00"),
                BackgroundColor(colorName="Yellow", colorHexa="#FFFF00"),
                BackgroundColor(colorName="Khaki", colorHexa="#F0E68C"),
                BackgroundColor(colorName="PeachPuff", colorHexa="#FFDAB9"),
                BackgroundColor(colorName="Moccasin", colorHexa="#FFE4B5"),
                BackgroundColor(colorName="PaleGoldenrod", colorHexa="#EEE8AA"),
                BackgroundColor(colorName="MistyRose", colorHexa="#FFE4E1"),
                BackgroundColor(colorName="LavenderBlush", colorHexa="#FFF0F5"),
                BackgroundColor(colorName="Lavender", colorHexa="#E6E6FA"),
                BackgroundColor(colorName="Thistle", colorHexa="#D8BFD8")
                )
        }
    }

}