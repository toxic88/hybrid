package playn.html;

import playn.core.Canvas;
import playn.core.CanvasImage;
import playn.core.Image;
import playn.core.PlayN;
import playn.core.gl.GLContext;
import playn.core.gl.Scale;

import com.google.gwt.canvas.dom.client.CanvasPixelArray;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.ImageData;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ImageElement;

/**
 * <p>
 * I want add possibility save canvas image into image as PNG.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
class HtmlCanvasImage extends HtmlImage implements CanvasImage {

	private static final String IMAGE_PNG = "image/png";
	private HtmlCanvas canvas;

	public HtmlCanvasImage(GLContext ctx, Scale scale, HtmlCanvas canvas) {
		super(ctx, scale, canvas.canvas());
		this.canvas = canvas;
	}

	@Override
	public Canvas canvas() {
		return canvas;
	}

	@Override
	public Image snapshot() {
		String path = this.canvas.canvas().toDataUrl(IMAGE_PNG);
		ImageElement img = Document.get().createImageElement();
	    img.setSrc(path);
	    img.setWidth((int) width());
	    img.setHeight((int) height());
	    PlayN.log().warn("Created image snapshot from canvas object!");
	    Image im = new HtmlImage(PlayN.platform().graphics().ctx(), Scale.ONE, img);
	    PlayN.log().warn("Created HtmlImage snapshot from canvas object!");
	    return im;
	}

	@Override
	public int ensureTexture() {
		if (canvas.dirty()) {
			canvas.clearDirty();
			clearTexture();
		}
		return super.ensureTexture();
	}

	@Override
	public void setRgb(int startX, int startY, int width, int height,
			int[] rgbArray, int offset, int scanSize) {
		Context2d ctx = canvas.canvas().getContext2d();
		ImageData imageData = ctx.createImageData(width, height);
		CanvasPixelArray pixelData = imageData.getData();
		int i = 0;
		int dst = offset;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int argb = rgbArray[dst + x];
				pixelData.set(i++, (argb >> 16) & 255);
				pixelData.set(i++, (argb >> 8) & 255);
				pixelData.set(i++, (argb) & 255);
				pixelData.set(i++, (argb >> 24) & 255);
			}
			dst += scanSize;
		}
		ctx.putImageData(imageData, startX, startY);
	}
}
