package cn.scut.vertifycode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VertifyCode {

	private Random random = new Random();
	private int width = 70;
	private int height = 35;
	private String code = "23456789abcdefghijkmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
	private String[] fonts = { "宋体", "楷体", "Helvetica", "Palatino" };
	private int[] styles = { Font.BOLD, Font.ITALIC, Font.PLAIN,
			Font.BOLD + Font.ITALIC };
	private int[] sizes = { 22, 23, 19, 20 };
	private String text = "";

	private Color randomColor() {
		int r = random.nextInt(150);
		int g = random.nextInt(150);
		int b = random.nextInt(150);
		return new Color(r, g, b);
	}

	private String randomString() {
		char c = code.charAt(random.nextInt(code.length()));
		return String.valueOf(c);
	}

	private Font randomFont() {
		String name = fonts[random.nextInt(fonts.length)];
		int style = styles[random.nextInt(styles.length)];
		int size = sizes[random.nextInt(sizes.length)];
		return new Font(name, style, size);
	}

	private BufferedImage creatImage() {
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		return image;
	}

	public BufferedImage getImage() {
		BufferedImage bi = creatImage();
		Graphics2D g = (Graphics2D) bi.getGraphics();
		for (int i = 0; i < 4; i++) {
			g.setColor(randomColor());
			g.setFont(randomFont());
			String s = randomString();
			text = text.concat(s);
			g.drawString(s, 2 + i * (width / 4), height - 12);
			g.drawLine(i * (width / 4), i * (height / 4),
					random.nextInt(width), random.nextInt(height));
		}

		return bi;
	}

	public void output(BufferedImage image,OutputStream out) throws Exception {
		ImageIO.write(image, "JPEG", out);
	}

	public String getText() {
		return text;
	}

}
