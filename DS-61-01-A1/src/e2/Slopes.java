package e2;

//import java.util.Arrays;

public class Slopes {

    public static int downTheSlope ( char [][] slopeMap , int right , int down ) {
        int i, j; //counters
        int counter = 0; //number of crashes
        int x = 0, y = 0; //counter in the axis X and Y
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

        if( slopeMap[y][x] == '#' ) { counter++; } //check the first
        while( y < slopeMap.length ){ //the limit is the Y axis
            for(j = 0; j < right; j++) {
                x++; //advance
                if( x == slopeMap[y].length ) { x = 0; } //if you surpass the X axis...
                if( slopeMap[y][x] == '#' ) { counter++; } //check
            }
            for(i = 0; i < down; i++) {
                y++; //advance
                if( y == slopeMap.length ) { return counter; } //check the last line
                if( slopeMap[y][x] == '#' ) { counter++; } //check
            }
        }
        return counter;
    }

    public static int jumpTheSlope ( char [][] slopeMap , int right , int down ) {
    int i, j; //counters
    int counter = 0; //number of crashes
    int x = 0, y = 0; //counter in the axis X and Y
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

        if( slopeMap[y][x] == '#' ) { counter++; } //check the first
        while( y < slopeMap.length ){
        for(j = 0; j < right; j++) {
            x++; //advance
            if( x == slopeMap[y].length ) { x = 0; }
        }
        for(i = 0; i < down; i++) {
            y++; //advance
            if( y == slopeMap.length ) { return counter; } //check the last line
        }
        if( slopeMap[y][x] == '#' ) { counter++; } //check
    }
        return counter;
}
}
