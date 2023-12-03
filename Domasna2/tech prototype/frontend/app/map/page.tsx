'use client'
import React from "react";
import {
	Drawer,
	DrawerBody,
	DrawerFooter,
	DrawerHeader,
	DrawerOverlay,
	DrawerContent,
	DrawerCloseButton,
	Input,
	useDisclosure,
	HStack,
	Button
} from "@chakra-ui/react";

export default function Map({ children, ...rest }) {
	
	const { isOpen, onOpen, onClose } = useDisclosure();
	const btnRef = React.useRef();

	return (
    	<>
			<div
				style={{
					backgroundImage: `url('/map1.png')`,
					backgroundRepeat: 'no-repeat',
					width: '100%',
					height: '90%',
					backgroundPosition: 'center',
					backgroundSize: 'cover',
					padding: '5vh',
				}}
			>
				<HStack
					justifyContent="center"
					alignItems="center"
					spacing="12vw"
					background={"whiteAlpha.800"}
					paddingTop={"2vh"}
					paddingBottom={"2vh"}
					borderRadius={"15px"}
					marginRight={"5vw"}
					marginLeft={"5vw"}
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
						ref={btnRef}
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
					placement="right"
					onClose={onClose}
					trapFocus={false}
					closeOnOverlayClick={false}
					blockScrollOnMount={false}
				>
					{/* <DrawerOverlay /> */}
					<DrawerContent>
					<DrawerCloseButton />
					<DrawerHeader>Create your account</DrawerHeader>

					<DrawerBody>
						<Input placeholder="Type here..." />
					</DrawerBody>

					<DrawerFooter>
						<Button variant="outline" mr={3} onClick={onClose}>
						Cancel
						</Button>
						<Button colorScheme="blue">Save</Button>
					</DrawerFooter>
					</DrawerContent>
				</Drawer>
			</div>
    	</>
	);
};
