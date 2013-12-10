/**
 * Copyright 2010 The PlayN Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package playn.html;

import playn.core.Canvas;
import playn.core.gl.Scale;
import pythagoras.f.MathUtil;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Document;

class HtmlCanvas extends AbstractHtmlCanvas {

    private final CanvasElement canvas;
    private final float         width, height;

    public static HtmlCanvas create(Scale scale, float width, float height) {
        float sw = scale.scaledCeil(width), sh = scale.scaledCeil(height);
        HtmlCanvas canvas = new HtmlCanvas(sw, sh);
        canvas.scale(scale.factor, scale.factor);
        return canvas;
    }

    // ANTS_TAG : test this feature!
    @Override
    public Canvas clear() {
        this.canvas.setWidth((int) this.width);;
        this.canvas.setHeight((int) this.height);;
        return this;
    }

    @Override
    public final float width() {
        return width;
    }

    @Override
    public final float height() {
        return height;
    }

    HtmlCanvas(Context2d ctx, float width, float height) {
        this(ctx, null, width, height);
    }

    CanvasElement canvas() {
        return canvas;
    }

    private HtmlCanvas(float width, float height) {
        this(Document.get().createCanvasElement(), width, height);
    }

    private HtmlCanvas(CanvasElement canvas, float width, float height) {
        this(canvas.getContext2d(), canvas, width, height);
        canvas.setWidth(MathUtil.iceil(width));
        canvas.setHeight(MathUtil.iceil(height));
    }

    private HtmlCanvas(Context2d ctx, CanvasElement canvas, float width, float height) {
        super(ctx);
        this.canvas = canvas;
        this.width = width;
        this.height = height;
    }
}
