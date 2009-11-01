#!/usr/bin/env ruby

classpath = %w{src templates config}

Dir.glob("lib/*.jar").each do |d|
  classpath << d
end

File.open("script/server.bat", "w") do |f|
  f.write("java -cp #{classpath.join(';')} clojure.lang.Script src/jquery/server.clj")
end

File.open("script/console.bat", "w") do |f|
  f.write("java -cp #{classpath.join(';')} jline.ConsoleRunner clojure.main -i src/repl.clj")
end
