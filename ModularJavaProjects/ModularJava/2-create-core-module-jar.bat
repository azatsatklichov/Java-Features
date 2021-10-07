mkdir mlib 
echo jar -c -f mlib\net.modul.jar -C output .
jar -c -f  mlib\core.modul.jar -C output .
echo move core.modul.jar mlib

echo jar tvf mlib\core.modul.jar
jar tvf mlib\core.modul.jar