var renderer = new THREE.WebGLRenderer({canvas: document.getElementById("canvas"), antialias: true});
renderer.setPixelRatio(window.devicePixelRadio);
renderer.setSize(canvas.clientWidth, canvas.clientHeight, false);
renderer.setClearColor(0xd3d3d3); // it's a dark gray
renderer.shadowMap.enabled = true;

//camera
var camera = new THREE.PerspectiveCamera(75, window.innerWidth/window.innerHeight, 0.1, 1000);
var controls = new THREE.OrbitControls(camera, renderer.domElement);
camera.position.x = -100;
camera.position.y = -20;
camera.position.z = -100;

//plano
const gridHelper = new THREE.GridHelper(1000, 40);
//var axesHelper = new THREE.AxesHelper(2.25);

var scene = new THREE.Scene();
//scene.add(axesHelper);
scene.add(gridHelper);


//luz
var light = new THREE.DirectionalLight(0xffffff);
light.position.set(50, 100, 25);
scene.add(light);

var octree;
var q;

function createOctree(m, n) {
	let box = new Box(0, 0, 0, m/2, m/2, m/2);
	octree = new OcTree(box, n);
}

function createPoint(m, n) {
	for (let i = 0; i < n; i++) {
		let x = Math.random() * (m/2 + m/2) - m/2;
		let y = Math.random() * (m/2 + m/2) - m/2;
		let z = Math.random() * (m/2 + m/2) - m/2;
		let point = new Point(x, y, z);
		octree.insert(point);
	}
}

controls.update();

var animate = function() {
	requestAnimationFrame(animate);
	controls.update();
	renderer.render(scene, camera);
	
};

animate();