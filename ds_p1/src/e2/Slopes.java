package e2;

//import java.util.Arrays;

public class Slopes {

    public static int downTheSlope ( char [][] slopeMap , int right , int down ) {
        int i, j;
        int counter = 0;
        int x = 0, y = 0;
        //NON SQUARE MAPS
        for( i = 0; i < slopeMap.length; i++ ){ if (slopeMap[i].length != slopeMap.length) { throw new IllegalArgumentException(); } }
        //NON VALID CHARACTERS
        for( i = 0; i < slopeMap.length; i++ ){
            for( j = 0; j < slopeMap.length; j++ ){
                if ( (slopeMap[i][j] != '#') && (slopeMap[i][j] != '.') ) { throw new IllegalArgumentException(); }
            }
        }
        //NON VALID PARAMETERS
        if( (right > 10) || (down > 10) || (right < 1) || (down < 1) ) { throw new IllegalArgumentException(); }

        if( slopeMap[y][x] == '#' ) { counter++; }
        while( y < slopeMap.length ){
            for(j = 0; j < right; j++) {
                x++;
                if( x == slopeMap[y].length ) { x = 0; }
                if( slopeMap[y][x] == '#' ) { counter++; }
            }
            for(i = 0; i < down; i++) {
                y++;
                if( y == slopeMap.length ) { return counter; }
                if( slopeMap[y][x] == '#' ) { counter++; }
            }
        }
        return counter;
    }

    public static int jumpTheSlope ( char [][] slopeMap , int right , int down ) {
    int i, j;
    int counter = 0;
    int x = 0, y = 0;
    //NON SQUARE MAPS
        for( i = 0; i < slopeMap.length; i++ ){ if (slopeMap[i].length != slopeMap.length) { throw new IllegalArgumentException(); } }
    //NON VALID CHARACTERS
        for( i = 0; i < slopeMap.length; i++ ){
        for( j = 0; j < slopeMap.length; j++ ){
            if ( (slopeMap[i][j] != '#') && (slopeMap[i][j] != '.') ) { throw new IllegalArgumentException(); }
        }
    }
    //NON VALID PARAMETERS
        if( (right > 10) || (down > 10) || (right < 1) || (down < 1) ) { throw new IllegalArgumentException(); }

        if( slopeMap[y][x] == '#' ) { counter++; }
        while( y < slopeMap.length ){
        for(j = 0; j < right; j++) {
            x++;
            if( x == slopeMap[y].length ) { x = 0; }
        }
        for(i = 0; i < down; i++) {
            y++;
            if( y == slopeMap.length ) { return counter; }
        }
        if( slopeMap[y][x] == '#' ) { counter++; }
    }
        return counter;
}
}
