#!/bin/bash

echo -e "================= Installing Periodicraft =================\n"
rm -r ./install
mkdir install
curl www.google.com > ./install/file

if [ $1 == Mac ]; then
    echo "Installing on Mac"
    installfolder=$HOME"/Library/Application\ Support/"
elif [ $1 == Linux ]; then
    echo "Installing on Linux"
    installfolder=$HOME"/.minecraft"
else
    echo "OS Not Found, Exiting"
fi

echo $installfolder

curl https://github.com/Periodicraft-Dev/Periodicraft-Minecraft-Mod/archive/master.tar.gz > ./install/repo.tar.gz

curl http://files.minecraftforge.net/maven/net/minecraftforge/forge/1.6.4-9.11.1.953/forge-1.6.4-9.11.1.953-installer.jar > ./installer.jar

curl http://files.minecraftforge.net/maven/net/minecraftforge/forge/1.6.4-9.11.1.953/forge-1.6.4-9.11.1.953-src.zip > ./install/src.zip

curl https://s3.amazonaws.com/Minecraft.Download/launcher/Minecraft.jar > ./install/minecraft.jar

echo "\n>>>> Please Choose your correct minecraft folder and install forge for client, DO NOT CANCEL, or installation will fail"

java -jar ./installer.jar

unzip ./install/src.zip

chmod +x ./forge/install.sh
cd ./forge/
./install.sh
cd ../

tar -xf ./install/repo.tar.gz
mkdir ./forge/mcp/src/minecraft/mods/
mv ./periodicraft/ ./forge/mcp/src/minecraft/mods

chmod +x ./forge/reobfuscate.sh
chmod +x ./forge/recompile.sh

./forge/mcp/reobfuscate.sh
./forge/mcp/recompile.sh

mkdir $installfolder/mods

mv ./forge/reobf/mods $installfolder/mods

# USE TAR tar -xf ./FILE.tar.xz

