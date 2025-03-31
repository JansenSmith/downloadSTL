import eu.mihosoft.vrl.v3d.CSG

String url

if(args==null){
	throw new IllegalArgumentException("No url provided")
} else {
	url = args.get(0)
}

if (!url.endsWith(".stl")) {
	throw new IllegalArgumentException("The URL must end with '.stl'")
}

// Extract the file name from the URL (assuming last part after "/")
String fileName = url.substring(url.lastIndexOf("/") + 1)

System.out.println("Downloading: " + fileName)

File foo = DownloadManager.download("0.1.0", 
									url, 
									(long)16, 
									"~/bin", 
									fileName, 
									fileName)

CSG geom  = Vitamins.get(foo);
			
return geom