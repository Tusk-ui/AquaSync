package fonts;

import java.awt.Font;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FontLoader {
    private static final Map<String, Font> loadedFonts = new HashMap<>();

    /**
     * Loads a font dynamically from the resources folder, supporting both `.ttf` and `.otf`.
     *
     * @param fontName The name of the font file without the extension (e.g., "HomeVideo-Regular").
     * @param size     The desired font size.
     * @return The loaded Font object, or a fallback font if loading fails.
     */
    public static Font loadFont(String fontName, float size) {
        if (loadedFonts.containsKey(fontName)) {
            return loadedFonts.get(fontName).deriveFont(size);
        }

        // Possible extensions to check
        String[] extensions = {".ttf", ".otf"};

        // Try loading the font with each extension
        for (String ext : extensions) {
            String fontPath = "/fonts/" + fontName + ext;
            try (InputStream is = FontLoader.class.getResourceAsStream(fontPath)) {
                if (is != null) {
                    Font font = Font.createFont(Font.TRUETYPE_FONT, is);
                    loadedFonts.put(fontName, font); // Cache the loaded font
                    return font.deriveFont(size);
                }
            } catch (Exception e) {
                System.err.println("Failed to load font: " + fontName + ext);
                e.printStackTrace();
            }
        }

        // Fallback font if neither `.ttf` nor `.otf` works
        return new Font("SansSerif", Font.PLAIN, (int) size);
    }

    /**
     * Test all fonts by loading them and printing their names.
     */
    public static void main(String[] args) {
        String[] fontNames = {
            "HomeVideo-Regular", "HomeVideo-Bold", "ClassyVoguePersonalUse",
            "NostalgicWhispers-Regular", "Cinzel-SemiBold", "Qilkabold-DO6BR",
            "Cinzel-VariableFont_wght", "Wonderful Future", "Cinzel-Bold",
            "Cinzel-Black", "Anastasia", "Laisha", "Cinzel-Regular",
            "Cinzel-Medium", "Cinzel-ExtraBold"
        };

        // Load and display all fonts
        for (String fontName : fontNames) {
            Font font = loadFont(fontName, 24f); // Default font size
            if (font != null) {
                System.out.println("Successfully loaded font: " + fontName + " (" + font.getFontName() + ")");
            } else {
                System.out.println("Failed to load font: " + fontName);
            }
        }
    }
}
