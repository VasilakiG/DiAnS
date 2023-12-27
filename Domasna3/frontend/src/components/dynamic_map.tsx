import React, { useEffect, useState } from "react";
import {
	Drawer,
	DrawerBody,
	DrawerFooter,
	DrawerHeader,
	DrawerContent,
	DrawerCloseButton,
	HStack,
	Button,
	Heading,
	VStack} from "@chakra-ui/react";
import dynamic from "next/dynamic";
const Image = dynamic(() => import('next/image'), { ssr: false });
import { MapContainer, Marker, Popup, TileLayer } from "react-leaflet";
import attractions from "@/components/shared/attractions/attractions";
import "leaflet/dist/leaflet.css";
import axios from "axios";
import { DivIcon, Icon } from "leaflet";


export default function DynamicMap({ ...rest }) {
	
	const [isOpen, setIsOpen] = useState(false);

	const [selectedCategory, setSelectedCategory] = useState('');
	const [selectedAttraction, setSelectedAttraction] = useState<{ name: string, lat: number, lng: number, category: string } | null>(null);
	//const [attractions, setAttractions] = useState([]);
	const [markers, setMarkers] = useState([0]);

	useEffect(() => {
		if (selectedCategory) {
		fetchAttractions(selectedCategory);
		}
	}, [selectedCategory]);

	const fetchAttractions = async (category: string) => {
		try {
		const response = await axios.get(`/attractions?category=${category}`);
		//setAttractions(response.data);
		} catch (error) {
		console.error('Error fetching attractions:', error);
		}
	};

	const [userLocation, setUserLocation] = useState<[number, number]>([0, 0]);

	const fetchUserLocation = () => {
		navigator.geolocation.getCurrentPosition(
		(position) => {
			setUserLocation([position.coords.latitude, position.coords.longitude]);
		},
		(error) => {
			console.error('Error getting user location:', error);
		}
		);
	};

	useEffect(() => {
		fetchUserLocation();
	}, []);

	const handleMarkerClick = (selectedMarker: number) => {
		// Remove all markers except the selected one
		setMarkers([selectedMarker]);
	};
	
	const onOpen = (category: React.SetStateAction<string>) => {
		setSelectedCategory(category);
		setIsOpen(true);
		setIsAttractionOpen(false);
		//fetch('http://localhost:3000/api/museums')
	};

	const onClose = () => setIsOpen(false);

	const [isAttractionOpen, setIsAttractionOpen] = useState(false);

	const onAttractionOpen = (attraction: { name: string, lat: number, lng: number, category: string }) => {
	setSelectedAttraction(attraction);
	setIsAttractionOpen(true);
	setIsOpen(false);
	};


	const onAttractionClose = () => setIsAttractionOpen(false);

	return (
		<>
			<HStack
				h={"auto"}
				w={"80vw"}
				position="absolute"
				justifyContent="center"
				alignItems="center"
				spacing="12vw"
				background={"whiteAlpha.800"}
				paddingTop={"2vh"}
				paddingBottom={"2vh"}
				borderRadius={"15px"}
				marginTop={"3vh"}
				marginLeft={"10vw"}
				zIndex={"100"}
			>
				<Button
					borderRadius={"20px"}
					paddingLeft={"2vw"}
					paddingRight={"2vw"}
					backgroundColor={"black"}
					color={"white"}
					onClick={() => onOpen('Archeological Sites')}
				>
					Archeological Sites
				</Button>
				<Button
					borderRadius={"20px"}
					paddingLeft={"2vw"}
					paddingRight={"2vw"}
					backgroundColor={"black"}
					color={"white"}
					onClick={() => onOpen('Museums')}
				>
					Museums
				</Button>
				<Button
					borderRadius={"20px"}
					paddingLeft={"2vw"}
					paddingRight={"2vw"}
					backgroundColor={"black"}
					color={"white"}
					onClick={() => onOpen('Aircraft')}
				>
					Aircraft
				</Button>
				<Button
					borderRadius={"20px"}
					paddingLeft={"2vw"}
					paddingRight={"2vw"}
					backgroundColor={"black"}
					color={"white"}
					onClick={() => onOpen('Religious')}
				>
					Religious
				</Button>
			</HStack>

			<Drawer
				variant="alwaysOpen"
				{...rest}
				isOpen={isOpen}
				placement="left"
				onClose={onClose}
				trapFocus={false}
				closeOnOverlayClick={false}
				blockScrollOnMount={false}
				size={'lg'}
			>
				{/* <DrawerOverlay /> */}
				<DrawerContent>
				<DrawerCloseButton />
				<DrawerHeader
					paddingTop={"5vh"}
					paddingLeft={"3vw"}
					fontSize={"2vw"}
				>
					{`${selectedCategory.charAt(0).toUpperCase() + selectedCategory.slice(1)} near you:`}
				</DrawerHeader>

				<DrawerBody>
					<ul>
						{attractions
							.filter((attraction) => attraction.category === selectedCategory)
							.map((attraction) => (
								<Button
									padding={"2vw"}
									background={"transparent"}
									color={"black"}
									_hover={{ background: "transparent" }}
									height={"auto"}
									width={"100%"}
									justifyContent={"left"}
									key={attraction.id as number}
									onClick={() => onAttractionOpen(attraction)}
								>
									<Heading
										fontSize={"1.3vw"}
										textAlign={"center"}
										fontWeight={"400"}
										paddingRight={"3vw"}
									>
										{attraction.name as string}
									</Heading>
								</Button>
							))}
					</ul>

				</DrawerBody>

				<DrawerFooter>
				</DrawerFooter>
				</DrawerContent>
			</Drawer>

			<Drawer
				variant="alwaysOpen"
				{...rest}
				isOpen={isAttractionOpen}
				placement="left"
				onClose={onAttractionClose}
				trapFocus={false}
				closeOnOverlayClick={false}
				blockScrollOnMount={false}
				size={'lg'}
			>
				{/* <DrawerOverlay /> */}
				<DrawerContent>
				<DrawerCloseButton />

				<DrawerBody>
					<VStack
						paddingTop={"10vh"}
						paddingBottom={"3vh"}
						spacing={"3vh"}
						alignItems={"center"}
						justifyContent={"center"}
						width={"auto"}
					>
						<Heading
							fontSize={"1.3vw"}
							textAlign={"center"}
							fontWeight={"400"}
						>
							{selectedAttraction && selectedAttraction.name}
						</Heading>
					</VStack>

					<VStack
						paddingTop={"6vh"}
						paddingBottom={"3vh"}
						paddingLeft={"5vw"}
						spacing={"3vh"}
						alignItems={"left"}
						justifyContent={"left"}
						width={"auto"}
					>
						<HStack
							width={"auto"}
							spacing={"1vw"}
						>
							<Image
								src={'/location.png'}
								alt={'location pin'}
								width={30}
								height={30}
							/>
							<Heading
								fontSize={"1.3vw"}
								textAlign={"center"}
								fontWeight={"400"}
							>
								{selectedAttraction && (
									<>
										Lng: {selectedAttraction.lng} Lat: {selectedAttraction.lat}
									</>
								)}
							</Heading>
						</HStack>

						<HStack
							width={"auto"}
							spacing={"1vw"}
						>
							<Image
								src={'/museumLogo.png'}
								alt={'location pin'}
								width={30}
								height={30}
							/>
							<Heading
								fontSize={"1.3vw"}
								textAlign={"center"}
								fontWeight={"400"}
								>
								Type: {selectedAttraction && selectedAttraction.category}
							</Heading> 
						</HStack>
					</VStack>


					<Button
						marginLeft={"10vw"}
						marginTop={"5vh"}
						fontSize={"1vw"}
						paddingLeft={"2vw"}
						paddingTop={"2.7vh"}
						paddingRight={"2vw"}
						paddingBottom={"2.7vh"}
						background={"#5DB3FF"}
						color={"white"}
						_hover={{ background: "black" }}
						height={"2vh"}
						width={"10vw"}
						//onClick={}
					>
						Get Directions
					</Button>
					
				</DrawerBody>

				<DrawerFooter>
				</DrawerFooter>
				</DrawerContent>
			</Drawer>

			<MapContainer
				style={{
					position: 'relative',
					width: '100%',
					height: '90vh',
					padding: '5vh',
					zIndex: '0',
				}}
				center={[41.99646, 21.43141]}
				zoom={15}
				scrollWheelZoom={true}
			>
				<TileLayer
					attribution='&amp;copy <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors'
					url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
				/>

				{attractions
					.filter((attraction) => attraction.category === selectedCategory)
					.map((attraction) => (
					<Marker
						icon={
							new DivIcon({
							className: 'custom-marker',
							html: `<img src="/locationPin.png" alt="marker" />`,
							iconSize: [30, 30],
							iconAnchor: [15, 30],
							popupAnchor: [0, -30],
							})
						}
						key={attraction.id}
						position={[attraction.lat, attraction.lng]}
						eventHandlers={{
							click: () => onAttractionOpen(attraction),
						}}
					>
						<Popup>{attraction.name}</Popup>
					</Marker>
				))}
			</MapContainer>
		</>
	);
};