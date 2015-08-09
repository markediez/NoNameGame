package net.codelets.javaplatformer.mapping;

import net.codelets.javaplatformer.GamePanel;
import net.codelets.javaplatformer.objects.Block;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Mark on 8/8/2015.
 */
public class Map {
    private String mapPath;
    private Block[][] blocks;
    private int width;
    private int height;
    private String[] mapLine;

    public Map(String mapPath) {
        this.mapPath = mapPath;
        loadMap(mapPath);
    }

    public void update() {
        for(int i = 0; i < blocks.length; i++) {
            for(int j = 0; j < blocks[i].length; j++) {
                blocks[i][j].update(blocks);
            }
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                blocks[i][j].draw(g);
            }
        }
    }

    private void loadMap(String mapPath) {
        // Loads the File
        try {
            InputStream inputStream = new FileInputStream(mapPath);
            // Reads the File
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            this.width = Integer.parseInt(bufferedReader.readLine());
            this.height = Integer.parseInt(bufferedReader.readLine());
            this.blocks = new Block[height][width];
            this.mapLine = new String[height];

            for(int y = 0; y < height; y++) {
                mapLine[y] = bufferedReader.readLine();
            }

            // Set Blocks
            for (int y = 0; y < height; y++) {
                StringTokenizer tokens = new StringTokenizer(mapLine[y]);
                for(int x = 0; x < width; x++) {
                    blocks[y][x] = new Block(GamePanel.WIDTH/4 + x*(Block.BLOCK_SIZE + 1), GamePanel.HEIGHT + y * (Block.BLOCK_SIZE + 1), Integer.parseInt(tokens.nextToken()));
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void read() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        for(String line : mapLine) {
            System.out.println(line);
        }
    }
    // getter
    public Block[][] getBlocks() { return blocks; }
}
