# friendwall

Learned aquired from: https://www.youtube.com/channel/UCFCaMBSbXWg1bfaQ0tUpA-w

## Installation
- Install leiningen (https://leiningen.org/#install)
- Install docker and configure it
    
        $ sudo apt-get install docker
        $ sudo docker network create -d bridge docker-network --subnet=172.17.0.0/24
        $ sudo docker run -network docker-network --ip 172.17.0.2 --name scrapbook_db -e POSTGRES_PASSWORD=123456 -d postgres

## Usage

- Start postgres container if not already started

        $ sudo docker start scrapbook_db

- Open a terminal into root directory and run the project

        $ sudo lein run

## License

Copyright © 2021

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
