mkdir mlib 

echo create core.modul.jar from output folder
jar -c -f  mlib\core.modul.jar -C output .

echo move core.modul.jar into mlib 
jar tvf mlib\core.modul.jar