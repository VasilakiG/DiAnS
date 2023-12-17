import React, { useState } from "react";
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
	Spacer,
	VStack,
	Container} from "@chakra-ui/react";
import Layout from "@/components/layout/layout";
import dynamic from "next/dynamic";
const Image = dynamic(() => import('next/image'), { ssr: false });
import { MapContainer, TileLayer } from "react-leaflet";
import "leaflet/dist/leaflet.css";

export default function DynamicMap({ ...rest }) {
	
	const [isOpen, setIsOpen] = useState(false);

	const onOpen = () => {
		setIsOpen(true);
		setIsMuseum1Open(false);
		setIsDirectionsOpen(false);
	};

	const onClose = () => setIsOpen(false);


	const [isMuseum1Open, setIsMuseum1Open] = useState(false);

	const onMuseum1Open = () => {
		setIsMuseum1Open(true);
		setIsOpen(false);
		setIsDirectionsOpen(false);
	};

	const onMuseum1Close = () => setIsMuseum1Open(false);

	const [isDiectionsOpen, setIsDirectionsOpen] = useState(false);

	const onDirectionsOpen = () => {
		setIsDirectionsOpen(true);
		setIsMuseum1Open(false);
		setIsOpen(false);
	};

	const onDirectionsClose = () => setIsDirectionsOpen(false);

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
				>
					Historical
				</Button>
				<Button
					borderRadius={"20px"}
					paddingLeft={"2vw"}
					paddingRight={"2vw"}
					backgroundColor={"black"}
					color={"white"}
					onClick={onOpen}
				>
					Museums
				</Button>
				<Button
					borderRadius={"20px"}
					paddingLeft={"2vw"}
					paddingRight={"2vw"}
					backgroundColor={"black"}
					color={"white"}
				>
					Nature
				</Button>
				<Button
					borderRadius={"20px"}
					paddingLeft={"2vw"}
					paddingRight={"2vw"}
					backgroundColor={"black"}
					color={"white"}
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
					Museums near you:
				</DrawerHeader>

				<DrawerBody>
					<Button
						padding={"2vw"}
						background={"transparent"}
						color={"black"}
						_hover={{ background: "transparent" }}
						height={"auto"}
						width={"100%"}
						onClick={onMuseum1Open}
					>
						<Image
							src={'/museum1.png'}
							alt={'museum1'}
							width={200}
							height={200}
						/>
						<Spacer />
						<Heading
							fontSize={"1.3vw"}
							textAlign={"center"}
							fontWeight={"400"}
							paddingRight={"3vw"}
						>
							Archaeological<br/>Museum of<br/>Macedonia
						</Heading>
					</Button>

					<Button
						padding={"2vw"}
						background={"transparent"}
						color={"black"}
						_hover={{ background: "transparent" }}
						height={"auto"}
						width={"100%"}
						onClick={onMuseum1Open}
					>
						<Image
							src={'/museum2.png'}
							alt={'museum2'}
							width={200}
							height={200}
						/>
						<Spacer />
						<Heading
							fontSize={"1.3vw"}
							textAlign={"center"}
							fontWeight={"400"}
							paddingRight={"3vw"}
						>
							Mother Theresa<br/>Memorial House
						</Heading>
					</Button>

					<Button
						padding={"2vw"}
						background={"transparent"}
						color={"black"}
						_hover={{ background: "transparent" }}
						height={"auto"}
						width={"100%"}
						onClick={onMuseum1Open}
					>
						<Image
							src={'/museum3.png'}
							alt={'museum3'}
							width={200}
							height={200}
						/>
						<Spacer />
						<Heading
							fontSize={"1.3vw"}
							textAlign={"center"}
							fontWeight={"400"}
							paddingRight={"3vw"}
						>
							Old Railway<br/>Skopje City<br/>Museum
						</Heading>
					</Button>
					
				</DrawerBody>

				<DrawerFooter>
				</DrawerFooter>
				</DrawerContent>
			</Drawer>

			<Drawer
				variant="alwaysOpen"
				{...rest}
				isOpen={isMuseum1Open}
				placement="left"
				onClose={onMuseum1Close}
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
						<Image
							src={'/museum1.png'}
							alt={'museum1'}
							width={429}
							height={284}
							/>
						<Heading
							fontSize={"1.3vw"}
							textAlign={"center"}
							fontWeight={"400"}
							>
							Archaeological Museum of<br/>Macedonia
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
								Location: Skopje
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
								Type: Museum
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
						onClick={onDirectionsOpen}
					>
						Get Directions
					</Button>
					
				</DrawerBody>

				<DrawerFooter>
				</DrawerFooter>
				</DrawerContent>
			</Drawer>

			<Drawer
				variant="alwaysOpen"
				{...rest}
				isOpen={isDiectionsOpen}
				placement="left"
				onClose={onDirectionsClose}
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
						<Image
							src={'/museum1.png'}
							alt={'museum1'}
							width={429}
							height={284}
							/>
						<Heading
							fontSize={"1.3vw"}
							textAlign={"center"}
							fontWeight={"400"}
							>
							Archaeological Museum of<br/>Macedonia
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
								Location: Skopje
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
								Type: Museum
							</Heading> 
						</HStack>
					</VStack>

					<Heading
						fontSize={"1.3vw"}
						textAlign={"center"}
						fontWeight={"400"}
						marginTop={"3svh"}
						paddingRight={"3vw"}
					>
						Follow the line, estimated distance 2km.
					</Heading>

					
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

			</MapContainer>
		</>
	);
};