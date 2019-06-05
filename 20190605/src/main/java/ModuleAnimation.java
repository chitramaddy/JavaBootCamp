public class ModuleAnimation
{
    public static void main( String[] args ) throws Exception
    {
        for ( int i=0; i<90; i++ )
        {
            if ( i%9 == 0 )
                System.out.print(" *_* *_* *_* *_*                 \r");
            else if ( i%9 == 1 )
                System.out.print("    *_* *_* *_* *_*                \r");
            else if ( i%9 == 2 )
                System.out.print("       *_* *_* *_* *_*             \r");
            else if ( i%9 == 3 )
                System.out.print("         *_* *_* *_* *_*           \r");
            else if ( i%9 == 4 )
                System.out.print("            *_* *_* *_* *_*         \r");
            else if ( i%9 == 5 )
                System.out.print("               *_* *_* *_* *_*       \r");
            else if ( i%9 == 6 )
                System.out.print("                 *_* *_* *_* *_*     \r");
            else if ( i%9 == 7 )
                System.out.print("                   *_* *_* *_* *_*   \r");
            else if ( i%9 == 8 )
                System.out.print("                     *_* *_* *_* *_* \r");
            else if ( i%9 == 7 )
                System.out.print("                 *_* *_* *_* *_*   \r");
            else if ( i%9 == 6 )
                System.out.print("             *_* *_* *_* *_*     \r");
            else if ( i%9 == 5 )
                System.out.print("         *_* *_* *_* *_*       \r");
            else if ( i%9 == 4 )
                System.out.print("     *_* *_* *_* *_*         \r");
            else if ( i%9 == 3 )
                System.out.print("  * *_* *_* *_*           \r");
            else if ( i%9 == 2 )
                System.out.print("    *_**_**_**_*             \r");
            else if ( i%9 == 1 )
                System.out.print(" *_**_**_**_*               \r");

            Thread.sleep(200);
        }

    }
}