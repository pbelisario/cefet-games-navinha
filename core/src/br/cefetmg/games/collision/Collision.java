package br.cefetmg.games.collision;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Utilitário para verificação de colisão.
 *
 * @author fegemo <coutinho@decom.cefetmg.br>
 */
public class Collision {

    /**
     * Verifica se dois círculos em 2D estão colidindo.
     * @param c1 círculo 1
     * @param c2 círculo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean circlesOverlap(Circle c1, Circle c2) {
        float distanciaEixoX = (c1.x - c2.x) * (c1.x - c2.x);
        float distanciaEixoY = (c1.y - c2.y) * (c1.y - c2.y);
        float DistanciaEntreDoisPontosAoQuadrado = distanciaEixoX + distanciaEixoY;
        return ((c1.radius + c2.radius) * (c1.radius + c2.radius)  > DistanciaEntreDoisPontosAoQuadrado);
    }

    /**
     * Verifica se dois retângulos em 2D estão colidindo.
     * Esta função pode verificar se o eixo X dos dois objetos está colidindo
     * e então se o mesmo ocorre com o eixo Y.
     * @param r1 retângulo 1
     * @param r2 retângulo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean rectsOverlap(Rectangle r1, Rectangle r2) {
        float R1MaxX = r1.x + r1.width, R1MinX = r1.x;
        float R1MaxY = r1.y + r1.height, R1MinY = r1.y;
        float R2MaxX = r2.x + r2.width, R2MinX = r2.x;
        float R2MaxY = r2.y + r2.height, R2MinY = r2.y;
        return (R1MaxX >= R2MinX && R1MinX <= R2MaxX && R1MaxY >= R2MinY && R1MinY <= R2MaxY);
        
    }
    
    public static final boolean rectsCirclesOverlap (Rectangle r1, Circle c1) {
        Vector2 CentroDoRetangulo = new Vector2();
        r1.getCenter(CentroDoRetangulo);
        Vector2 CentroDoCirculo = new Vector2 (c1.x, c1.y);
        
        return (CentroDoCirculo.dst(CentroDoRetangulo) <= c1.radius + r1.width/2
                && CentroDoCirculo.dst(CentroDoRetangulo) <= c1.radius + r1.height/2);
    }
}
