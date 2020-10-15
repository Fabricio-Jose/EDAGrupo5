class Point {
	constructor(x, y, z, userData) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.geometry = new THREE.SphereGeometry(2, 10, 10);
		this.material = new THREE.MeshPhongMaterial();
		this.sphere = new THREE.Mesh(this.geometry, this.material);
		this.sphere.position.set(this.x, this.y, this.z);
		
	}
}

class Box {
	constructor(x, y, z, w, h, d) {
		this.x = x; // center
		this.y = y;
		this.z = z;
		this.w = w; // half width
		this.h = h; // half height
		this.d = d; // half depth
	}

	contains(point) {
		
		if (point.x <= parseInt(this.x,10) + parseInt(this.w,10) && 
            point.y <= parseInt(this.y,10) + parseInt(this.h,10) && 
            point.z <= parseInt(this.z,10) + parseInt(this.d,10) &&
			point.x >= parseInt(this.x,10) - parseInt(this.w,10) &&
			point.y >= parseInt(this.y,10) - parseInt(this.h,10) &&
			point.z >= parseInt(this.z,10) - parseInt(this.d,10)) {
			return 1;
		}
		return 0;
	}

	intersects(range) {
		return !(parseInt(range.x,10) - parseInt(range.w,10) > parseInt(this.x,10) + parseInt(this.w,10) || 
				parseInt(range.x,10) + parseInt(range.w,10) < parseInt(this.x,10) - parseInt(this.w,10) ||
				parseInt(range.y,10) - parseInt(range.h,10) > parseInt(this.y,10) + parseInt(this.h,10) ||
				parseInt(range.y,10) + parseInt(range.h,10) < parseInt(this.y,10) - parseInt(this.h,10) ||
				parseInt(range.z,10) - parseInt(range.d,10) > parseInt(this.z,10) + parseInt(this.d,10) ||
				parseInt(range.z,10) + parseInt(range.d,10) < parseInt(this.z,10) - parseInt(this.d,10));
	}
}

class OcTree {
	constructor(boundary, n) {
		this.boundary = boundary; // object Box;
		this.capacity = n; 
		this.points = []; // points array 
		this.divided = false;

		this.color = new THREE.Color(Math.random()*1, Math.random()*1, Math.random()*1);

		this.geometry = new THREE.BoxGeometry(boundary.w*2, boundary.h*2, boundary.d*2);
		this.material = new THREE.MeshBasicMaterial({color: 0x00ff00, opacity: 0.23, transparent: true});
		this.material.color.set(this.color);
		this.box = new THREE.Mesh(this.geometry, this.material);
		//this.box.position.set(boundary.x, boundary.y, boundary.z);
		this.box.position.set(boundary.x, boundary.y, boundary.z);
		scene.add(this.box);
	}

	buscarPunto(point)
	{
		for (let p of this.points)
		{
			if(p.x===point.x&&p.y===point.y&&p.z===point.z){
				return true;
			}
		}
		return false;
	}

	subdivide() {
		let x = this.boundary.x;
		let y = this.boundary.y;
		let z = this.boundary.z;
		let w = this.boundary.w/2;
		let h = this.boundary.h/2;
		let d = this.boundary.d/2;

		let b_topRightFront    = new Box(x + w, y + h, z + d, w, h, d);
		let b_topLeftFront     = new Box(x - w, y + h, z + d, w, h, d);
		let b_bottomRightFront = new Box(x + w, y - h, z + d, w, h, d);
		let b_bottomLeftFront  = new Box(x - w, y - h, z + d, w, h, d);
		let b_topRightBack     = new Box(x + w, y + h, z - d, w, h, d);
		let b_topLeftBack      = new Box(x - w, y + h, z - d, w, h, d);
		let b_bottomRightBack  = new Box(x + w, y - h, z - d, w, h, d);
		let b_bottomLeftBack   = new Box(x - w, y - h, z - d, w, h, d);

		this.topRightFront    = new OcTree(b_topRightFront, this.capacity);
		this.topLeftFront     = new OcTree(b_topLeftFront, this.capacity);
		this.bottomRightFront = new OcTree(b_bottomRightFront, this.capacity);
		this.bottomLeftFront  = new OcTree(b_bottomLeftFront, this.capacity);
		this.topRightBack     = new OcTree(b_topRightBack, this.capacity);
		this.topLeftBack      = new OcTree(b_topLeftBack, this.capacity);
		this.bottomRightBack  = new OcTree(b_bottomRightBack, this.capacity);
		this.bottomLeftBack   = new OcTree(b_bottomLeftBack, this.capacity);

		this.divided = true;
	}

	insert(point) {
		if (!this.boundary.contains(point)) {
			return false;
		}
		if (this.points.length < this.capacity) {
			if(!this.buscarPunto(point))
			{
				this.points.push(point);
				point.material.color.set(this.color);
				scene.add(point.sphere);
				return true;
			}
			return false;
			
		}
		else {
			if (!this.divided) {
				this.subdivide();
			}
			return this.topRightFront.insert(point) ||
			this.topLeftFront.insert(point) ||
			this.bottomRightFront.insert(point) ||
			this.bottomLeftFront.insert(point) ||
			this.topRightBack.insert(point) ||
			this.topLeftBack.insert(point) ||
			this.bottomRightBack.insert(point) ||
			this.bottomLeftBack.insert(point);
		}
	}

	/*query(range, found) {
		if (this.boundary.intersects(range)==false) {
            return false;
        }
        else{
			for (let p of this.points) {
				if (range.contains(p)) {
					p.sphere.color.set(new THREE.Color(255, 0, 0));
					found.push(p);
				}
			}
			if (this.divided==true) {
				this.topRightFront.query(range, found);
				this.topLeftFront.query(range, found);
				this.bottomRightFront.query(range, found);
				this.bottomLeftFront.query(range, found);
				this.topRightBack.query(range, found);
				this.topLeftBack.query(range, found);
				this.bottomRightBack.query(range, found);
				this.bottomLeftBack.query(range, found);
			}    
            return true;
        }
	}*/
		query(range, found) {
		if (this.boundary.intersects(range)) {
			for (let p of this.points) {
				
				if (range.contains(p)) {
					
					p.material.color.set(new THREE.Color(255, 0, 0));
					found.push(p);
				}
			}
			if (this.divided) {
				this.topRightFront.query(range, found);
				this.topLeftFront.query(range, found);
				this.bottomRightFront.query(range, found);
				this.bottomLeftFront.query(range, found);
				this.topRightBack.query(range, found);
				this.topLeftBack.query(range, found);
				this.bottomRightBack.query(range, found);
				this.bottomLeftBack.query(range, found);
			}
		}
	}

	cleanQuery(box) {
        if(this.boundary.intersects(box)) {
            for(let p of this.points) {
                if(box.contains(p)) {
                    p.material.color.set(this.color);
                }
            }
            if(this.divided) {
                this.topRightFront.cleanQuery(box);
				this.topLeftFront.cleanQuery(box);
				this.bottomRightFront.cleanQuery(box);
				this.bottomLeftFront.cleanQuery(box);
				this.topRightBack.cleanQuery(box);
				this.topLeftBack.cleanQuery(box);
				this.bottomRightBack.cleanQuery(box);
				this.bottomLeftBack.cleanQuery(box);
            }
        }
    }
}
