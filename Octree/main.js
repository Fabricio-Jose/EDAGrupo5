var scene = new THREE.Scene();
var camera = new THREE.PerspectiveCamera( 75, window.innerWidth / window.innerHeight, 0.1, 1000 );

//var renderer = new THREE.WebGLRenderer();
//renderer.setSize( window.innerWidth, window.innerHeight );
//document.body.appendChild( renderer.domElement );

renderer = new THREE.WebGLRenderer({ antialias: true });
renderer.setClearColor(0xd3d3d3); // it's a dark gray
renderer.setPixelRatio(window.devicePixelRatio || 1);
renderer.setSize(window.innerWidth, window.innerHeight);
renderer.shadowMap.enabled = true;
document.body.appendChild(renderer.domElement);


var controls = new THREE.OrbitControls( camera, renderer.domElement );
camera.position.set( 0, 10, 10 );
controls.update();

var light = new THREE.DirectionalLight(0xffffff);
light.position.set(50, 100, 25);
scene.add(light);


var geometry = new THREE.BoxGeometry();
var material = new THREE.MeshBasicMaterial({color: new THREE.Color(0.9, 0.55, 0.8), opacity: 0.2 , transparent: true,});
var cube = new THREE.Mesh( geometry, material );
scene.add( cube );

var sphere_geometry = new THREE.SphereGeometry(0.01, 32, 32);
var sphere_material = new THREE.MeshPhongMaterial({color: new THREE.Color(0.9, 0.55, 0.8)});
sphere = new THREE.Mesh(sphere_geometry, sphere_material);
scene.add(sphere);

camera.position.z = 5;



////////////////////

class Point{
    constructor(x,y,z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.geometry = new THREE.SphereGeometry( 2, 10, 10 );
        this.material = new THREE.MeshBasicMaterial();
        this.sphere = new THREE.Mesh( this.geometry, this.material );
        this.sphere.position.set(x,y,z);
        scene.add( this.sphere );
    }
}

class Box{
    constructor(x,y,z,w,h,d){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
    }

    contains(point){
        return (point.x >= (this.x - this.w) && 
        point.x <= (this.x + this.w) && 
        point.y >= (this.y - this.h) && 
        point.y <= (this.y + this.h) &&
        point.z >= (this.z - this.d) &&
        point.z <= (this.z + this.d)); 
    }

    intersects(box){
        return !(box.x - box.w > this.x + this.w  ||
        box.x + box.w < this.x - this.w  ||
        box.y - box.h > this.y + this.h  ||
        box.y + box.h < this.y - this.h  ||
        box.z - box.d > this.z + this.d  ||
        box.z + box.d < this.z - this.d);
    }
}

var animate = function () {
    requestAnimationFrame( animate );
    controls.update();
    cube.rotation.x += 0.01;
    cube.rotation.y += 0.01;

    renderer.render( scene, camera );
};

animate();