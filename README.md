# kheo  
[![License](http://img.shields.io/:license-mit-blue.svg)](http://doge.mit-license.org)  

====
## Overview
This repository contains some deployments sample for Kheo application. 

### Docker
Run application layers in docker containers:

The database must be run first.
```
docker run -d -p 27017:27017 --name kheo-db mongo:latest
```

The backend container linked to the `kheo-db` container
```
docker run -d -p 8080:8080 -p 8081:8081 --name kheo-api --link kheo-db:kheo-db kheo-api
```

The web frontend container linked to the `kheo-api` container
```
docker run -d -p 8000:80 -v ${PWD}/kheo-web/dist:/var/www/html --name kheo-web --link kheo-api:kheo-api dockerfile/nginx
```

### Fig / Docker compose
To make it easier to use, there is a fig config file that let you start each layer inside a container:
```sudo fig up -d``` (Run this command in the directory containing fig.yml)

### Ansible
Kheo comes with sample Ansible playbooks that deploys components through your machines.

There are sample playbooks for those topologies:
- all-in-one: All Kheo components are deployed on one machine
- simple: Each component is deployed on a machine

You can execute the playbook following these steps:
```
sudo ansible-galaxy install bennojoy.mongo_mongod
sudo ansible-galaxy install jdauphant.nginx
sudo ansible-galaxy install ANXS.oracle-jdk
ansible-playbook -i inventory kheo.yml --private-key=key
```

Or simply spawn vagrant VMs with `vagrant up` in a directory containing a Vagrantfile.
