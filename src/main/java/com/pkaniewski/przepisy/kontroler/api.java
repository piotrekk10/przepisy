package com.pkaniewski.przepisy.kontroler;

import com.pkaniewski.przepisy.dao.Recipe;
import com.pkaniewski.przepisy.serv.RecipeService;
import org.aspectj.util.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class api {
    RecipeService recipeService;

    public api(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/image/{id}")
    public byte[] test(@PathVariable String id) throws IOException {
        Recipe recipe = recipeService.findById(Long.parseLong(id));
        File file = new File(recipe.getPicturePath());
        ByteArrayInputStream in = new ByteArrayInputStream(FileUtil.readAsByteArray(file));
        try {
            BufferedImage img = ImageIO.read(in);

            Image scaledImage = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
            BufferedImage imageBuff = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
            imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0, 0, 0), null);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ImageIO.write(imageBuff, "jpg", buffer);
            return buffer.toByteArray();
        } catch (IOException e) {

        }


        return FileUtil.readAsByteArray(file);
    }
}
